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
    // console.log("relativizing " + url + " : "  + lecture_base + " : " + base)
    if (url == "") return url
    for (;;) {
        if (url.match('^' + base)) {
            url = url.replace(base, lecture_base)
            // console.log("result = " + url)
            return url
        }
        const base_match = base.match('^(.*)/')
        if (!base_match) { 
            // console.log("base didn't match -> " + url)
            return url
        }
        base = base_match[1] 
        const lec_base_match = lecture_base.match('^(.*)/')
        if (!lec_base_match) {
            // console.log("lecture_base didn't match -> " + url)
            return url
        }
        lecture_base = lec_base_match[1]
        // console.log("  base = " + base)
        // console.log("  lecture_base = " + lecture_base)
    }
}

function hide_answers() {
    const answers = document.getElementsByClassName("answer")
    for (const a of answers) {
        a.style.display = 'none'
        const show = EZDom.p({className: 'showAnswer'}, "(Show answer)")
        a.parentNode.insertBefore(show, a)
        show.onclick = (e) => {
            a.style.display = 'block'
            show.style.display = 'none'
        }
    }
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
    hide_answers()
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
