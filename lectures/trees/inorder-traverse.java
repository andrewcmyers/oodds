/** Apply the method visit() to every node in the tree, using an in-order traversal. */
void traverse() {
    if (left != null) left.traverse();
    visit(data);
    if (right != null) right.traverse();
}
