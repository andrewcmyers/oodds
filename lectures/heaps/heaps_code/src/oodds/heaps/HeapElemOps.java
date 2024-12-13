package oodds.heaps;

import java.util.Comparator;

public interface HeapElemOps<Element, Priority> extends Comparator<Priority> {
    /** The priority of element E. */
    Priority priority(Element elem);

    /** Compare two priorities. */
    int compare(Priority priority1, Priority priority);

    /** Effect: set the priority of {@code elem} to {@code priority}. */
    void setPriority(Element elem, Priority priority);

    /** The current position of the element in the priority queue. */
    int position(Element elem);

    /** Effect: Record the position of the element in the priority queue. */
    void setPosition(Element e, int pos);
}