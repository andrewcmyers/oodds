/** Insert element x into the binary search tree, unless it is already there.
    Return true if the element was inserted, false if it was already there.
 */
boolean insert(T x, Comparator<T> cmp) {
    int c = cmp.compare(x, data);
    if (c == 0) return false;
    if (c < 0) {
        if (left != null) return left.insert(x);
        left = new BinaryNode<T>(x);
    } else {
        if (right != null) return right.insert(x);
        right = new BinaryNode<T>(x);
    }
    return true;
}
