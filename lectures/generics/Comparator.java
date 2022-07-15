interface Comparator<T> {
    /** Compares x and y. Return 0 if x and y are equal, a negative number if x < y, 
     *  and a positive number if x > y.
     */
    int compareTo(T x, T y);
}
