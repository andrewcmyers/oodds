class Visitor {
    void visitA(A n) {}
    void visitB(B n) {}
}

/** A Visitor for traversal X */
class XVisitor extends Visitor {
    void visitA(A n) {
        ... supply behavior for A nodes in traversal X ...
    }
    // Note: no new behavior for B nodes
}
