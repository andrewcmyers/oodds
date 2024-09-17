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
        'preface',
        'intro',
        'objects',
        'pitfalls',
        'java_rep',
        'encapsulation',
        'subtyping',
        'intf_design',
        'exceptions',
        'inheritance',
        'mod_design',
        'testing',
        'recursion_lists',
        'generics',
        'complexity',
        'trees',
        'parsing',
        'hashtables',
        'loopinv',
        'sorting',
        'graphs',
        'traversals',
        'ssp',
        'heaps',
        'avl',
        'undecidability',
        'patterns',
        gui,
        guievents,
        'uidesign',
        'concurrency',
        'synchronization',
        'jvm'
    ]
})()
