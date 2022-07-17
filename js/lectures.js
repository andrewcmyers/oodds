var base_url = basename(window.location.origin + window.location.pathname)

function load_lecture() {
    const idpat = /\?id=([_a-z]*)/;
    const locstr = location.toString();
    const a = locstr.match(idpat);
    if (a) {
        url = base_url + "/lectures/" + a[1] + "/index.html";
        fetch_content("content", url, () => localizeContent(url), "text/html");
    }
}

function basename(url) {
    return url.replace(/\/[^\/]*$/, "")
}
var base_url = basename(window.location.origin + window.location.pathname)


function relativize(url, lecture_base, base) {
    url = url.replace(base, lecture_base)
    return url
}

function localizeContent(lecture_url) {
    const lecture_base = basename(lecture_url)
    let nodenum = 0;
    const pre_nodes = document.getElementsByTagName('pre');
    for (const n of pre_nodes) {
        if (n.className != "load") continue;
        const id = n.id;
        const kids = n.childNodes;
        const link = kids[0];
        if (link.tagName != 'A') continue;
        if (id == null || id == "") {
            n.id = "id_pre_node_" + (++nodenum);
        }
        n.removeChild(link);
        fetch_code(n.id, relativize(link.href, lecture_base, base_url));
    }
    const img_nodes = document.getElementsByTagName('img')
    for (const img of img_nodes) {
        img.src = relativize(img.src, lecture_base, base_url)
    }
    colorize_all();
    italicize_document_math();
    for (const script of document.getElementsByClassName('graphics')) {
      try {
        eval(script.textContent);
      } catch (err) {
        console.error('Error setting up web page: ' + err);
      }
    }
    MathJax.typeset()
}

function elem(n) {
  if (n == "") alert("empty id?!");
  return document.getElementById(n);
}

function clear(node) {
  if (node == undefined) return;
  while (node.firstChild) node.removeChild(node.firstChild);
}
