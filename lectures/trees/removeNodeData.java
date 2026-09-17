/// Effect: remove this node from the tree, or if it
///   has two children, replace its data with the data of
///   another node that is removed.
/// Requires: p is the parent of this node unless
///   this node has 2 children.
private void removeNodeData(BinaryNode<T> p) {
    if (left == null && right == null) {
        // case 1: prune
        replaceChild(p, this, null);
    } else if (left == null) {
        // case 2L: splice n.right
        replaceChild(p, this, right);
    } else if (right == null) {
        // case 2R: splice n.left
        replaceChild(p, this, left);
    } else { // case 3: two children: move data
        var next = right;
        var nextp = this;
        while (next.left != null) {
            nextp = next;
            next = next.left;
        }
        data = next.data;
        next.removeNodeData(nextp); // recurse (must be case 1 or 2)
    }
}

/// Effect: replace child of parent with replacement
static <T> void replaceChild(BinaryNode<T> parent, BinaryNode<T> child,
    @Nullable BinaryNode<T> replacement) {
    if (parent.left == child) parent.left = replacement;
    else parent.right = replacement;
}
