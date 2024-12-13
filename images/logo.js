const canvas = document.getElementsByTagName("canvas")[0]

const figure = new Constrain.Figure(canvas)

with (figure) {
    const diameter = variable()
    const m = margin(20)

    function node(i) {
        return circle().setW(diameter).setFillStyle("blue")
    }
    equal(diameter, times(m.h(), 0.25))

    let nodes = [0, 1, 2, 3, 4, 5].map(i => node(i))

    align("none", "bottom", nodes[3], nodes[4], nodes[5], m)
    align("left", "none", nodes[3], m)
    align("right", "none", nodes[5], m)
    align("distribute", "bottom", nodes[3], nodes[4], nodes[5])
    align("center", "top", nodes[0], m)
    nodes[1].at(average(nodes[0], nodes[3]))
    nodes[2].at(average(nodes[0], nodes[5]))
    setLineWidth(times(diameter, 0.5))
    setStrokeStyle("blue")
    connector(nodes[0].center(), nodes[1].center())
    connector(nodes[0].center(), nodes[2].center())
    connector(nodes[1].center(), nodes[3].center())
    connector(nodes[1].center(), nodes[4].center())
    connector(nodes[2].center(), nodes[5].center())


}
Constrain.autoResize()
figure.start()
