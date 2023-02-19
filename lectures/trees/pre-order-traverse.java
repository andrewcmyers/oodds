/** Apply the method visit() to every tree node, using a preorder traversal. */
void traverse() {
    visit(data);
    if (left != null) left.traverse();
    if (right != null) right.traverse();
}
