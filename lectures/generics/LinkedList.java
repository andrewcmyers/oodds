/** A mutable list. */
class LList<T> implements Collection<T> {
    int size = 0;
    Node<T> head = null; // reference to first Node; null if list is empty

    boolean contains(T x) {
        Node<T> n = head;
        while (n != null) {
            if (x.equals(n.data)) return true;
            n = n.next;
        }
        return false;
    }
    
    boolean add(T x) {
        head = new Node<T>(x, head);
        size++;
    }
    
    boolean remove(T x) {
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
    
    T head() {
       if (head == null) throw new NoSuchElementException();
       return head.data;
    }
   
    Node<T> tail() {
       if (head == null) throw new NoSuchElementException();
       return head.next;
    }

    // ... more methods ...
}
