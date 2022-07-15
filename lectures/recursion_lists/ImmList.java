/**
 * An immutable, ordered, finite sequence of objects
 * (a_{0}, a_{1}, ..., a_{n-1}), which may be empty.
 */
interface ImmList {
    /** Returns: the first object in the list (a_{0}).
     *  Checks: the list is not empty. */
    Object first();

    /** Returns: a list containing all elements but the first, i.e.,
     * (a_{1}, ..., a_{n-1})
     *  Checks: the list is not empty. */
    ImmList rest();

    /** Returns whether this is the empty list. */
    boolean empty();

    /** Returns: a list containing the same elements as this,
     *  but with the object x inserted at the beginning. That is,
     *  (x, a_{1}, ..., a_{n-1}) 
     *  Checks: the list is not empty. */
    ImmList cons(Object x)
}
