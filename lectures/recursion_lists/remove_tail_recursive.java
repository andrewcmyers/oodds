/** Returns: a list containing all the nodes in the list starting at n, except
 *  for the first node containing data x, if any.
 *  Effects: if p != null, sets p.next to the returned list,
 *           and modifies the original list
 */
Node remove(Node n, Object x, Node p) {
    if (n == null) return n;
    if (n.data.equals(x)) {
        if (p != null) p.next = n.next;
        return n.next;
    }
    return remove(n.next, x, p.next); // recursive case
}
