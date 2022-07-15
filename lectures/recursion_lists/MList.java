class MList implements MutList {
    private Node head;
    // invariant: size is the number of nodes in the list starting with head.
    private int size;
    // The last element in the list. Is null iff head is null.
    private Node last;

    int size() { return size; }

    void prepend(Object x) {
        head = new Node(x, head);
        size++;                        // restore the size invariant
    }
    void append(Object x) {
	Node n = new Node(x, null);
	if (head == null)
	    head = last = n;
	else
	    last.next = n;
	size++;
    }
    boolean remove(Object x) {
        Node n = head, p = null;
        while (n != null && !x.equals(n.data)) {
            p = n;
            n = n.next;
        }
        if (n == null) return false;
        size--;
        if (p == null) head = n.next;
        else p.next = n.next; // splice out n
        return true;
    }
}

