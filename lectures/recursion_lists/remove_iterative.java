Node remove(Node n, Object x) {
    Node result = n;
    Node p = null;
    while (n != null && !n.data.equals(x)) {
        p = n;
        n = n.next;
    }
    if (n == null) return result;
    if (result == n) return n.next;
    p.next = n.next; // splice out n
    return result;
}
