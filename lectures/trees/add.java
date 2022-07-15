/** Add element x to the binary search tree, unless it is already there.
    Return true if the element was added, false if it was already there.
 */
boolean add(T x, Comparator<T> cmp) {
    int c = cmp.compare(x, data);
    if (c == 0) return false;
    if (c < 0) {
        if (left != null) return left.add(x);
        left = new BinaryNode<T>(x);
    } else {
        if (right != null) return right.add(x);
        right = new BinaryNode<T>(x);
    }
    return true;
}
