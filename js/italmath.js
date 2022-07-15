// Rewrite math expressions so alphabetic characters (letters) are made italic.
//
// author: Andrew Myers

var math_fcns = ["log", "lim", "lg", "if", "iff", "max", "min", "frac", "mod", "ln"]
var math_fcns_lookup = {}

math_fcns.forEach(name => {
    math_fcns_lookup["&" + name] = true
})

function italicize_text(t) {
    let r = []
    while (t != "") {
        const m = t.match(/[a-zA-Z]+/)
        if (!m) {
            r.push(EZDom.text(t))
            break
        }
        let index = m.index
        if (index > 0) {
            r.push(EZDom.text(t.slice(0, index)))
            t = t.slice(index)
        }
        const w = m[0]
        if (math_fcns_lookup["&" + w]) r.push(text(w))
          else r.push(EZDom.i(w))
        t = t.slice(w.length)
    }
    return EZDom.span({className: "math_ital"}, ...r)
}

function italicize_node_math(n) {
    const kids = n.childNodes;
    for (let i = 0; i < kids.length; i++) {
        const k = kids[i]
        if (k.nodeType == Node.TEXT_NODE) {
            if (k.nodeValue.match(/[a-zA-Z]/)) {
                n.replaceChild(italicize_text(k.nodeValue), k)
            }
        } else if (!k.classList.contains("noital") && !k.classList.contains("math_ital")) {
            italicize_node_math(k)
        }
    }
}

// Apply coloring to all text inside <pre> or <code> elements in the document.
function italicize_document_math() {
    let m_tags = document.getElementsByClassName('m'),
        math_tags = document.getElementsByClassName('math'),
        math_elts = [];

    for (let i=0; i < m_tags.length; i++) {
        math_elts.push(m_tags[i]);
    }
    for (let i=0; i < math_tags.length; i++) {
        math_elts.push(math_tags[i]);
    }
    math_elts.forEach(italicize_node_math);
}
