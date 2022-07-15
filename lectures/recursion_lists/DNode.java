class DNode {
    DNode prev, next;
    /* invariant: If next ≠ null, next.prev = this.
                  If prev ≠ null, prev.next = this. */
    Object data;
}
