/** An object that knows how to order itself with respect to other objects of
 *  the same type.
 */
interface Comparable<T> {
    /** Return 0 if {@code this == y}, a positive number if {@code this > y},
     *  and a negative number if {@code this < y}.
     */
    int compare(T y);
}
