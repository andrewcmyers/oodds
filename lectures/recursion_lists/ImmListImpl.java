class ImmListImpl implements ImmList {
    private Node head; // may be null to represent empty list

    public ImmListImpl() {
        head = null;
    }
    public boolean empty() {
        return (head == null);
    }
    public Object first() {
        assert head != null;
        return head.data;
    }
    public ImmList rest() {
        assert head != null;
        ImmListImpl r = new ImmListImpl();
        r.head = head.next;
        return r;
    }
    public ImmList cons(Object x) {
        ImmListImpl r = new ImmListImpl();
        r.head = new Node(x, head); // assuming appropriate Node constructor
        return r;
    }
}
