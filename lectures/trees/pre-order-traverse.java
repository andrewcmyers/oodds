/** Apply the method visit() to every node in the tree, using a preorder traversal. */
void traverse() {
    visit(data);
    if (left != null) left.traverse();
    if (right != null) right.traverse();
}
