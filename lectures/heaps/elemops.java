interface HeapElemOps<E, P> extends Comparator<P> {
    /** The priority of element E. */
    P priority(E elem);

    /** Compare two priorities. */
    int compare(P priority1, P priority);

    /** Effect: set the priority of {@code elem} to {@code priority}. */
    void setPriority(E elem, E priority);

    /** The current position of the element in the priority queue. */
    int position(E elem);

    /** Effect: Record the position of the element in the priority queue. */
    void setPosition(E e, int position);
}
