/** Returns: the list starting at head, except for the first node at or after
 *  n containing data x, if any.
 *  Requires: n is a node in the list starting at head (or null), and p is
 *    the node preceding n in that list, or null if n == head.
 *  Effects: modifies the original list.
 */
Node remove(Node n, Object x, Node p, Node head) {
    if (n == null) return head;
    if (n.data.equals(x)) {
        if (p == null) return n.next;
        p.next = n.next; // splice out n
        return head;
    }
    return remove(n.next, x, n, head); // recursive case
}
