static boolean contains(BinaryNode<T> n, T x, Comparator<T> cmp) {
    while (n != null) {
        int c = cmp.compare(x, n.data);
        if (c == 0) return true;
        n = (c < 0) ? left : right;
    }
    return false;
}
