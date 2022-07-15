// EZDom:
//
// Making it convenient to create DOM nodes from JavaScript.  Creates
// functions EZDom.tag for various different tag names.  Arguments
// become children of the newly created DOM node. Text and numeric
// arguments may be provided and are converted to text nodes.  An
// optional first argument that is a plain object specifies attributes
// for the created DOM node.
//
// Andrew Myers, June 2013.
//
// Only puts EZDom into scope.
// For convenience, may be used as `with (EZDom) { ... }`

var EZDom = {
    // A few useful tags. More could be added.
    tags : [
        "ul", "li", "ol", "p", "b", "i", "em", "table", "thead", "tbody", "tr",
        "td", "th", "div", "span", "h1", "h2", "h3", "h4", "a", "br", "hr", "input",
        "blockquote", "select", "option", "sup", "sub", "strong", "pre", "canvas",
        "button", "img", "form", "textarea", "kbd", "code"
    ],

    toString: function() { return "EZDom module" },

    text : function(t) {
        return document.createTextNode(t)
    },

    /* Append k as a child of n. Create a text node if k is a string.  */
    app : function(n, k) {
        switch (typeof k) {
            case "string":
                n.appendChild(this.text(k)); break;
            case "number":
            case "boolean":
            case "function":
                n.appendChild(this.text(k.toString())); break;
            case "object":
                if (k == null)
                    n.appendChild(this.text("<null>"))
                else if (k.constructor == Array)
                    for (i in k)
                        this.app(n, k[i])
                else
                    n.appendChild(k)
        }
        return n
    },

    /* Create an HTML DOM element with children and, optionally, attributes.
    *   tag: the tag name, e.g. 'p', 'ul', etc.
    *   attributes: an object containing additional attributes to be copied to
    *      the node.
    *   kids: a variable length sequence of element arguments. Arguments may be
    *         strings, in which case a text node is created. An argument that is
    *         an array causes all of its contained elements to be inserted.
    */
    node : function(tag) {
        var n = document.createElement(tag),
            firstkid = 1,
            attr = arguments[1]
        if (attr != undefined && attr.constructor == Object) {
            for (var prop in attr)
                n[prop] = attr[prop]
            firstkid = 2
        }
        for (var i = firstkid; i < arguments.length; i++)
            this.app(n, arguments[i])
        return n
    },

    /* Install a tag as a top-level function. 
    */
    install_tag : function(tag) {
        var ezdom = this

        this[tag] = function(args) {
            var nargs = new Array(tag)
            nargs.length = arguments.length+1
            for (var i = 0; i < arguments.length; i++)
                nargs[i+1] = arguments[i]
            return ezdom.node.apply(ezdom, nargs)
        }
    },
    clear : function(node) {
        if (node == undefined) return
        while (node.firstChild) node.removeChild(node.firstChild)
    },
    init : function() {
        for (var t in EZDom.tags)
            EZDom.install_tag(EZDom.tags[t])
    }
}

EZDom.init()
