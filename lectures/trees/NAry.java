/* Tree node with children stored in an array */
class ArrayTreeNode<T> {
    T data;
    ArrayTreeNode<T>[] children;
}

/* Tree node with children stored in a linked list */
class ListTreeNode<T> {
    T data;
    LinkedList<ListTreeNode<T>> children;
}
