abstract class Node {
    void accept(Visitor v);
}

class A extends Node {
    void accept(Visitor v) {
        v.visitA(this);
    }
}

class B extends Node {
    void accept(Visitor v) {
        v.visitB(this);
    }
}
