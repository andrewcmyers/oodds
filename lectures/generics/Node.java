class Node<T> {
    T data;
    Node<T> next;

    Node(T d, Node<T> n) {
        data = d;
        next = n;
    }
}
