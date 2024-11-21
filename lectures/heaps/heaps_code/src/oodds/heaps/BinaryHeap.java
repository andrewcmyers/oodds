package oodds.heaps;

import java.util.ArrayList;

public class BinaryHeap<E, P> implements PriorityQueue<E, P> {
    HeapElemOps<E, P> ops;
    ArrayList<E> items;

    public BinaryHeap(HeapElemOps<E, P> ops) {
        this.ops = ops;
    }

    @Override
    public void add(E item) {
        items.add(item);
        bubbleUp(items.size() - 1);
    }

    /**
     * Swap items at index i and j in the heap array, and also
     * update their positions.
     * <p>
     * Requires: i and j be >= 0 and < size.
     */
    private void swap(int i, int j) {
        E temp = items.get(i);
        items.set(i, items.get(j));
        items.set(j, temp);
        ops.setPosition(items.get(i), i);
        ops.setPosition(items.get(j), j);
    }

    @Override
    public E extractMin() {
        E result = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        bubbleDown(0);
        return result;
    }

    /** Whether the item i has no higher priority than item j.
     * Requires: i, j are legal item positions.
     */
    private boolean comparePriorities(int i, int j) {
        P pi = ops.priority(items.get(i));
        P pj = ops.priority(items.get(j));
        return (ops.compare(pi, pj) >= 0);
    }

    /** Bubble down item k */
    private void bubbleDown(int k) {
        int size = items.size();
        if (k < 0 || k >= size) return;
        while (2 * k + 1 < size) {
            int c = 2 * k + 1;
            if (c + 1 < size && !comparePriorities(c+1, c)) {
                c++;
            }
            if (comparePriorities(c, k)) return;
            swap(k, c);
            k = c;
        }
    }

    /** Bubble up item k */
    private void bubbleUp(int k) {
        while (k > 0) {
            int parent = (k-1)/2;
            if (comparePriorities(k, parent)) return;
            swap(k, parent);
            k = parent;
        }
    }

    @Override
    public void increasePriority(E item, P priority) {
        int index = ops.position(item);
        bubbleUp(index);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
