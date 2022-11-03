(function setupLectureDirs() {
    const s = new URLSearchParams(location.search)
    let lectures
    let gui, guievents
    if (s.has('swing')) {
        gui = 'gui_swing'
        guievents = 'guievents_swing'
    } else {
        gui = 'gui'
        guievents = 'guievents'
    }

    window.lectures = [
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
        gui,
        guievents,
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
})()
