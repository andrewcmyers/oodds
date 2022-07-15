/** A mutable ordered list (a_{0}, a_{1}, ..., a_{n-1}) */
interface MutList {
    /** The number of objects in the list. */
    int size();

    /** Returns: The object at index i (a_{i}).
     *  Requires: 0 ≤ i < n */
    Object get(int i);

    /** Effects: Inserts x at the head of the list. */
    void prepend(Object x);

    /** Effects: Inserts x at the end of the list. */
    void append(Object x);

    /** Returns: true if x is in the list.
     *  Effects: Removes the first occurrence of object x from the list. */
    boolean remove(Object x);

    /** Returns: true if x is in the list. */
    boolean contains(Object x);

    ...more operations...
}
