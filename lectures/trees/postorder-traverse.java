/** Apply the method visit() to every tree node, using a postorder traversal. */
void traverse() {
    if (left != null) left.traverse();
    if (right != null) right.traverse();
    visit(data);
}
