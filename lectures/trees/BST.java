class BinaryNode<T> {
    T data;
    /** Invariant: {@code left} and {@code right} are the roots of subtrees,
     *  where all data in the left subtree are less than {@code data},
     *  according to some ordering on T, and all data in the right subtree
     *  are greater than {@code data}.
     *  The value {@code null} represents an empty subtree.
     */
    BinaryNode<T> left, right;
}
