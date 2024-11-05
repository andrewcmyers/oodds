interface HeapElemOps<E, P> extends Comparator<P> {
    /** The priority of element E. */
    P priority(E elem);

    /** Compare two priorities. */
    int compare(P priority1, P priority 2);

    /** Effect: set the priority of {@code elem} to {@code priority}. */
    void setPriority(E elem, P priority);

    /** The current position of the element in the priority queue. */
    PQueuePos<E> position(E elem);

    /** Effect: Record the position of the element in the priority queue. */
    void setPosition(PQueuePos<E> pos);
}
