class Stack {
    private Node top;

    void push(Object x) {
        top = new Node(x, top);
    }
    Object pop() {
        Object ret = top.data;
        top = top.next;
    }
}
