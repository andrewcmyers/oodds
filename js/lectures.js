var lectures = [
    'intro',
    'objects',
    'pitfalls',
    'java_rep',
    'encapsulation',
    'subtyping',
    'intf_design',
    'inheritance',
    'exceptions',
    'mod_design',
    'recursion_lists',
    'generics',
    'complexity',
    'trees',
    'hashtables',
    'loopinv',
    'sorting',
    'parsing',
    'patterns',
    'gui',
    'uidesign',
    'concurrency',
    'synchronization',
    'graphs',
    'traversals',
    'ssp',
    'heaps',
    'avl',
    'jvm',
    'undecidability'
]

var base_url = basename(window.location.origin + window.location.pathname)

function load_lecture() {
    const idpat = /\?id=([_a-z]*)/,
          locstr = location.toString(),
          match = locstr.match(idpat)
    if (match) {
        url = base_url + "/lectures/" + match[1] + "/index.html"
        const content = elem("content")
        fetch_content_node(content, url, () => localizeContent(content, url), "text/html")
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

function localizeContent(node, lecture_url) {
    const lecture_base = basename(lecture_url),
          lec_name = lecture_base.replace(/^.*\//, '')
    let nodenum = 0
    const pre_nodes = node.getElementsByTagName('pre')
    for (const n of pre_nodes) {
        if (n.className != "load") continue
        const id = n.id,
              kids = n.childNodes,
              link = kids[0]
        if (link.tagName != 'A') continue
        if (id == null || id == "") {
            n.id = "pre_node_" + lec_name + "_" + (++nodenum)
        }
        n.removeChild(link)
        fetch_code(n.id, relativize(link.href, lecture_base, base_url))
    }
    for (const img of node.getElementsByTagName('img')) {
        img.src = relativize(img.src, lecture_base, base_url)
    }
    for (const anchor of node.getElementsByTagName('a')) {
        anchor.href = relativize(anchor.href, lecture_base, base_url)
    }
    colorize_all(node)
    italicize_document_math()
    for (const script of node.getElementsByClassName('graphics')) {
      try {
        eval(script.textContent)
      } catch (err) {
        console.error('Error setting up web page: ' + lecture_url)
      }
    }
    MathJax.typeset()
}

function elem(n) {
  if (n == "") alert("empty id?!")
  return document.getElementById(n)
}

function clear(node) {
  if (node == undefined) return
  while (node.firstChild) node.removeChild(node.firstChild)
}
