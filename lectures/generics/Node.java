class Node<T> {
    T data;
    Node<T> next; // may be null

    /** Creates a linked list node containing data d, where n is the
     *  next node. Argument n may be null to indicate there is no next
     *  node. */
    Node(T d, Node<T> n) {
        data = d;
        next = n;
    }
}
