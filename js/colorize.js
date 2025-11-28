// Colorize web page code according to a list of keywords.
//
// colorize(id) recolors the code found in the <pre> element 'id'
//
// fetch_code(id, url) fetches code from the URL 'url', colors it, and inserts
// it into the <pre> element 'id'.
//
// fetch_code_region and fetch_code_redacted fetch code and trim out some parts of
// it before inserting into the web page.
// 
// author: Andrew Myers

var keyword_list = new Array( "abstract", "assert", "class", "else",
    "enum", "for", "function", "if", "new", "private", "public",
    "protected", "static", "throw", "throws", "try", "catch", "while",
    "return", "break", "continue", "case", "default", "switch", "do",
    "interface", "implements", "synchronized", "extends", "finally",
    "except", "instanceof", "this", "super" );

var reserved_words = new Array("void", "int", "boolean", "long",
    "short", "float", "double", "byte", "char");

var keywords = new Object;

for (let k in keyword_list) {
    keywords[keyword_list[k] + "$"] = 1;
}

function colorize(id) {
    colorize_node(document.getElementById(id));
}

//var first_colorize=true;

function colorize_text(t, fromRawCode) {
    if (fromRawCode) {
        if (window.navigator.appVersion.match(/Safari/)) {
          t=t.replace(/&/g,'&amp;').
              replace(/"/g,'&quot;');
        }
        t=t.replace(/>/g,'&gt;').
            replace(/</g,'&lt;');
    }
    //first_colorize=false;
    t=t.replace(/\n/g, '\n\0\0');
    let tokens = t.split(/\b|\0\0/g);
    let newt = "";
    let inscript = false;
    let commenting = false;
    let linecommenting = false;
    let instring = false;
    for (let i = 0; i < tokens.length; i++) {
	if (!inscript && tokens[i].match(/_/) && i < tokens.length - 1  && tokens[i+1].match(/{/)) {
	    tokens[i] = tokens[i].replace(/_/, "<span class=\"subscript\">");
	    inscript = true;
	} else if (!inscript && tokens[i].match(/\^{/)) {
	    tokens[i] = tokens[i].replace(/\^{/, "<span class=\"superscript\">");
	    inscript = true;
	} else if (inscript && tokens[i].match(/{/)) {
	    tokens[i] = tokens[i].replace(/{/, "");
	} else if (inscript && tokens[i].match(/}/)) {
	    tokens[i] = tokens[i].replace(/}/, "</span>");
	    inscript = false;
	}
	if (!commenting && !linecommenting && tokens[i].match(/\/\*/)) {
	    tokens[i] = tokens[i].replace(/\/\*/, "<span-class=\"comment\">/*");
	    newt += tokens[i];
	    commenting = true;
	} else if (!commenting && !linecommenting && tokens[i].match(/\/\//)) {
	    tokens[i] = tokens[i].replace(/\/\//, "<span-class=\"comment\">//");
	    newt += tokens[i];
	    linecommenting = true;
	} else if (linecommenting && tokens[i].match(/\r?\n/)) {
	    tokens[i] = tokens[i].replace(/(\r?)\n/, "</span>$1\n");
	    newt += tokens[i];
	    linecommenting = false;
	} else if (keywords[tokens[i] + "$"] && !commenting && !instring && !linecommenting) {
	    newt += '<span-class="keyword">' + tokens[i] + '</span>';
	} else if (tokens[i].match(/\*\/\s+\/\*/)) {
	    newt += tokens[i];
	    // commenting unchanged
	} else if (tokens[i].match(/\*\//)) {
	    newt += tokens[i].replace(/\*\//, "*/</span>");
	    commenting = false;
	} else if (tokens[i].match(/"[^"]*"/)) {
	    newt += tokens[i];
	} else if (tokens[i].match(/"/)) {
	    instring = !instring;
	    newt += tokens[i];
	} else {
	    newt += tokens[i];
	}
    }

    newt = newt.replace(/{@code ([^}]*)}/g,'<span class="varname">$1</span>');

    if (window.navigator.appName.match(/Internet Explorer/)) {
	// IE consumes whitespace when the innerHTML property is
	// assigned. So replace newlines with explicit breaks,
	// spaces with nbsps, tabs with eight nbsps.
	newt = newt.replace(/\r\n/g, "<br />");
	newt = newt.replace(/\n/g, "<br />");
	newt = newt.replace(/ /g, "&nbsp;");
	newt = newt.replace(/\t/g, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    }
    // this substitution is needed to support the IE compatibility hacks.
    newt = newt.replace(/span-class/g, "span class");
    //alert(newt);
    return newt;
}

function colorize_node(n) {
    let t = n.innerHTML;
    if (t == null) return;
    n.innerHTML = colorize_text(t, false);
}

// Apply coloring to all text inside <pre> or <code> elements in the specified node,
// or in the entire document if no argument is provided.
function colorize_all(node) {
    if (!node) node = document
    for (const code of node.getElementsByTagName('code')) {
        colorize_node(code)
    }
    for (const pre of node.getElementsByTagName('pre')) {
        colorize_node(pre)
    }
}

function redact(s) {
    s = s.replace(/\/\* Rest not in notes \*\/(.|\r|\n)*/, '');
    s = s.replace(/(.|\r|\n)*\/\* Above not in notes \*\/(\r|\n)?/, '');
    s = s.replace(/\/\* Begin ... in notes \*\/(.|\r|\n)*\/\* End ... \*\//, '...');
    return s;
}

// Fetch the source file at URL "url" and insert it into the <pre> with
// id attribute "id". Certain comments (see "redact") cause parts of the
// code to be redacted. The inserted code is hyperlinked so that clicking on it
// retrieves the whole file.
function fetch_code(id, url) {
    fetch_code_redacted(id, url, redact);
}

// Fetch the source file at URL "url" and insert a part of it into the <pre> with
// id attribute "id". The part inserted is that which lies between comments
// that indicate the beginning and ending of the region. For example, to tag a
// region as "my region", the source file should contain:
// ...  hidden code ...
// (* Begin my region *)
// ... code to fetch ...
// (* End my region *)
function fetch_code_region(id, url, tag) {
// ...  more hidden code ...
    function extract_region(s) {
	let pat = "^([\\b\\r\\n]|.)*\\(\\* Begin " + tag + " \\*\\)(.|[\\b])*\\n";
	let re = new RegExp(pat);
	s = s.replace(re, "");
	pat = "\\(\\* End " + tag + " \\*\\)([\\b\\r\\n]|.)*";
	s = s.replace(new RegExp(pat), "");
	return s;
    }
    fetch_code_redacted(id, url, extract_region);
}

// Fetch the source file at URL "url" and insert it into the <pre> with id
// attribute "id". Certain comments may cause parts of the code to be redacted,
// as defined by "redactor". The inserted code is hyperlinked so that clicking
// on it retrieves the whole file.
function fetch_code_redacted(id, url, redactor) {
    let node = document.getElementById(id);
    read_from_url(url,
        function(responseText) {
            node.innerHTML = '<a class="pre" href="' + url + '" title="Click to download code">' +
                colorize_text(redactor(responseText), true) +
                '</a>';
        },
        function(errmsg) {
            node.innerHTML = 'Could not read source code file at ' + url +
                                ': Error ' + errmsg;
        },
        "text/plain");
}
