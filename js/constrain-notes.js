// Convenient utility functions for using Constrain for course notes,
// especially for object diagrams

// How strongly graphs try to achieve their objectives, by default.
const GRAPH_COST = 0.001

// How densely laid out nodes in a graph are, relative to their size, by default.
const GRAPH_SPARSITY = 1

class LightStyle extends Constrain.Trees.TreeStyle {
    constructor(figure, specialEdges, specialNodes) {
        super(figure)
        this.specialEdges = new Set()
        if (specialEdges) specialEdges.forEach(g => this.specialEdges.add(g))
        this.specialNodes = new Set()
        if (specialNodes) specialNodes.forEach(n => this.specialNodes.add(n))
        this.specialEdgeColor = '#bbb'
        this.specialNodeColor = '#d66'
    }
    drawNode(s) {
        if (s === undefined) {
            return this.figure.point()
        } else {
            const result = this.figure.label("" + s)
            if (this.specialNodes.has(s)) result.setTextStyle(this.specialNodeColor)
            return this.figure.group(result, result.expand(5))
        }
    }
    drawEdge(n1, n2) {
        const result = this.figure.connector(n1.gobj, n2.gobj).setLineWidth(1.5)
        if (this.specialEdges.has(n2.value))
            result.setStrokeStyle('#bbb').setLineWidth(2)
        return result
    }
}

class CFigure extends Constrain.Figure {
    constructor(canvas, advance) {
        super(canvas)
        this.setLineWidth(1)
        this.setFontName("verdana, helvetica, arial, sans-serif")
        this.setFontSize(12)
        this.setFadeColor("#eee")
        this.boxw = 80
        this.boxh = 20

        if (advance) {
            this.setRepeat(true)
            this.align("right", "bottom", this.advanceButton(), this.margin())
        }
        setTimeout(() => this.start())
    }

    varBoxes(...names_values) {
        const extra = []
        const rects = names_values.map(n => {
            let name, value
            if (n.constructor === Array) {
                [name, value] = n
            } else {
                name = n
            }
            if (/=/.test(name)) {
                [name, value] = name.split("=")
            }
            let boxh = this.boxh
            if (value) {
                let match_result;
                if (match_result = value.match(/^(.*)\|([0-9]+)$/)) {
                    boxh = this.times(boxh, parseInt(match_result[2]))
                    value = match_result[1]
                }
            }
            const r = this.rectangle().setW(this.boxw).setH(boxh)
            if (name == "class") {
                name = ""
                r.setFillStyle("#ddd")
            }
            if (name) {
                let l = this.label(name + " ").setFillStyle("black")
                this.align("abut", "center", l, r)
                extra.push(l)
            }
            if (value != undefined) {
                let l = this.label("" + value).setFillStyle("black")
                extra.push(l)
                this.pin(l.center(), r.center())
            }
            return r
        })
        this.align("left", "abut", rects)
        const rect_group = this.group(rects)
        let result = this.group(rect_group, extra)
        result.x2 = function() { return rect_group.x0() }
        result.getVar = function(i) { return rects[i] }
        result.center = () => this.point(this.average(result.x2(), result.x1()), result.y())
        return result
    }

    pointer(...objs) {
        let connected = objs
        for (let i = 0; i < connected.length; i++) {
            if (typeof connected[i] == "string") {
                let result
                if (result = connected[i].match(/^left( (.*))?$/)) {
                    let shift = undefined === result[2] ? 30 : parseInt(result[2])
                    connected[i] = connected[i+1].toLeft(shift)
                } else
                if (result = connected[i].match(/^right( (.*))?$/)) {
                    let shift = undefined === result[2] ? 30 : parseInt(result[2])
                    connected[i] = connected[i-1].toRight(shift)
                } else
                console.error("Unknown pointer spec: " + connected[i])
            }
        }
        connected =  [ objs[0].toRight(-15), objs[0].toRight(15), ...objs.slice(1) ]
        return this.connector(connected).setEndArrow("arrow").setStartArrow("bullet").setLineWidth(2)
    }
    arrow(...objs) {
        return this.connector(...objs).setEndArrow("arrow")
    }

    animateCode(...lines) {
        const ttfont = 'consolas, Menlo, monospace';
        let preloaded = 0
        lines.forEach(txt => {
            if (/^\*/.test(txt)) {
                lines[preloaded++] = txt.slice(1)
            }
        })
        const inactives = lines.slice(preloaded).map(txt =>
                    this.label(txt).setFontName(ttfont).setFillStyle('#aaa')),
              actives = lines.map(txt => {
                return this.label(txt).setFontName(ttfont).setFillStyle('black')
              })
        this.align("left", "distribute", actives)
        for (let i = preloaded; i < actives.length; i++) {
            this.pin(actives[i].center(), inactives[i-preloaded].center())
            actives[i] = this.drawAfter(this.getFrame(i-preloaded+1), actives[i])
        }
        this.equal(this.plus(actives[0].y0(), this.getFont().getSize() * actives.length * 1.3),
                    actives[actives.length - 1].y1())
        return this.group(actives)
    }
    roundedRectangle(w, h) {
        return this.rectangle().setW(w).setH(h).setCornerRadius(16)
    }
    lightStyle(specialEdges, specialNodes) {
        return new LightStyle(this, specialEdges, specialNodes)
    }
}
