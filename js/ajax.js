// fetch the contents from the URL "url".  Once successful, apply the function
// "cont()" to the contents. If unsuccessful, apply the function err(msg).
function read_from_url(url, cont, err, mimetype) {
    var undefined;
    if (mimetype == undefined) mimetype = 'text/xml';
    let req;
    if (window.XMLHttpRequest) { // Mozilla, Safari, ...
        req = new XMLHttpRequest();
        if (req.overrideMimeType)
            req.overrideMimeType(mimetype);
    } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.onreadystatechange = function() {
        if (req.readyState == 4) {
            if (req.status == 200) {
                cont(req.responseText);
            } else {
                err('Could not read from ' + url + ': Error ' + req.status);
            }
        }
    }
    if (!url.match(/^http:/) && !url.match(/^https:/)) {
        let prefix = location.href;
        url = prefix.replace(/\/[^\/]*$/, '/') + url;
    }
    req.open("GET", url, true);
    req.send(null);
}

function post_to_url(url, params, cont, err, mimetype) {
    let undefined;
    if (mimetype == undefined) mimetype = 'text/xml';
    let req;
    if (window.XMLHttpRequest) { // Mozilla, Safari, ...
        req = new XMLHttpRequest();
        if (req.overrideMimeType)
            req.overrideMimeType(mimetype);
    } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.onreadystatechange = function() {
        if (req.readyState == 4) {
            if (req.status == 200) {
                cont(req.responseText)
            } else {
                err('Could not read from ' + url + ': Error ' + req.status);
            }
        }
    }
    if (!url.match(/^http:/) && !url.match(/^https:/)) {
        let prefix = location.href;
        url = prefix.replace(/\/[^\/]*$/, '/') + url;
    }

    let data = new FormData();
    for (var prop in params) {
	data.append(prop, params[prop]);
    }

    req.open("POST", url, true);
    req.send(data);
}

// fetch the contents from the URL "url" into DOM node "node".
// Once successful, apply the optionally provided function "cont()".
function fetch_content_node(node, url, cont, mimetype) {
    read_from_url(url,
        responseText => {
            node.innerHTML = responseText;
            let undefined;
            if (cont != undefined) cont();
        },
        errmsg => {
            node.innerHTML = errmsg;
        }, mimetype);
}

// fetch the contents from the URL "url" into the DOM node with id attribute
// "id".  Once successful, apply the optionally provided function "cont()".
function fetch_content(id, url, cont, mimetype) {
    const node = document.getElementById(id);
    fetch_content_node(node, url, cont, mimetype);
}
