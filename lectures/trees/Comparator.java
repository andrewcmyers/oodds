/** An object that knows how order objects of type T.
 */
interface Comparator<T> {
    /** Return 0 if {@code x} equals {@code y}, a positive number if {@code x > y},
     *  and a negative number if {@code x < y}.
     */
    int compareTo(T x, T y);
}
