interface HeapElemOps<E, P> {
    /** The priority of element E. */
    P priority(E elem);

    /** Effect: set the priority of {@code elem} to {@code priority}. */
    void setPriority(E elem, P priority);

    /** The current position of the element in the priority queue. */
    PQueuePos<E> position(E elem);

    /** Effect: Record the position of the element in the priority queue. */
    void setPosition(PQueuePos<E> pos);
}
