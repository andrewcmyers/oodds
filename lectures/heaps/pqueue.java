/**
 * A priority queue of elements of type E with a priority P.
 */
interface PriorityQueue<E, P> {
    /**
     * Effect: Pushes {@code elem} onto the queue at its
     *         current priority.
     */
    void add(E elem);
    
    /**
     * Effect: Removes and returns the element from the queue of
     *         highest priority.
     * Requires: Queue is nonempty.
     */
    E extractMin();
    
    /**
     * Effect: change the priority of {@code elem} to the new priority.
     * Has no effect if {@code priority} is lower than
     * {@code elem}'s current priority.
     * Requires: {@code elem} is already in the queue.
     */
    void increasePriority(E elem, P priority);
    
    /**
     * Returns: whether the queue is empty.
     */
    boolean isEmpty();
}
