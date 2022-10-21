class Node<T> {
    T data;
    Maybe<Node<T>> next;

    /** Creates a linked list node containing data d, where n is the
     *  next node, if any. */
    Node(T d, Maybe<Node<T>> n) {
        data = d;
        next = n;
    }
}
