function fix_url(url) {
    if (!url.match(/^http:/) && !url.match(/^https:/)) {
        let prefix = location.href;
        return prefix.replace(/\/[^\/]*$/, '/') + url;
    }
    return url
}

async function readEverything(stream) {
    const reader = stream.getReader()
    let chunks = []
    let done, value
    while (!done) {
        ({ done, value } = await reader.read())
        if (value) {
            chunks.push(new TextDecoder().decode(value))
        }
    }
    return chunks.join('')
}

// fetch the contents from the URL "url".  Once successful, apply the function
// "cont()" to the contents. If unsuccessful, apply the function err(msg).
function read_from_url(url, cont, err) {
    fetch(fix_url(url)).then(
        response => readEverything(response.body).then(cont),
        response => readEverything(response.body).then(err))
}

function post_to_url(url, params, cont, err) {
    let data = new FormData();
    for (var prop in params) {
	data.append(prop, params[prop]);
    }

    fetch(fix_url(url, {
        method: 'POST',
        body: data
    }))
        .then(cont, err)
}

// fetch the contents from the URL "url" into DOM node "node".
// Once successful, apply the optionally provided function "cont()".
function fetch_content_node(node, url, cont) {
    read_from_url(url,
        responseText => {
            node.innerHTML = responseText;
            let undefined;
            if (cont != undefined) cont();
        },
        errmsg => {
            node.innerHTML = errmsg;
        });
}

// fetch the contents from the URL "url" into the DOM node with id attribute
// "id".  Once successful, apply the optionally provided function "cont()".
function fetch_content(id, url, cont) {
    const node = document.getElementById(id);
    fetch_content_node(node, url, cont);
}
