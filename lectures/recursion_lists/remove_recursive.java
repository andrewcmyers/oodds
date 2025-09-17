/** Returns: a list containing all the nodes in the list starting at n, except
 *  for the first node containing data x, if any.
 *  Effects: modifies the original list.
 */
Node remove(Node n, Object x) {
    if (n == null) return n;
    if (n.data.equals(x)) return n.next;
    n.next = remove(n.next, x); // recursive case
    return n;
}
