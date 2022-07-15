boolean contains(T x, Comparator<T> cmp) {
    int c = cmp.compare(x, data);
    if (c == 0) return true;
    BinaryNode<T> child = (c < 0) ? left : right;
    if (child == null) return false;
    return child.contains(x);
}
