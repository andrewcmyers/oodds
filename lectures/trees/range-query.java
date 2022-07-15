/** Apply the method visit() to every node in the tree, using an in-order traversal. */
void visitRange(T bottom, T top, Comparator<T> cmp) {
    if (left != null && cmp.compare() left.traverse();
    visit(data);
    if (right != null) right.traverse();
}
