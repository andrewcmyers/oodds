package oodds.heaps;

import java.util.ArrayList;

public class BinaryHeap<E, P> implements PriorityQueue<E, P> {
    HeapElemOps<E, P, Integer> ops;
    ArrayList<E> elements;

    public BinaryHeap(HeapElemOps<E, P, Integer> ops) {
        this.ops = ops;
    }

    @Override
    public void add(E elem) {
        elements.add(elem);
        bubbleUp(elements.size() - 1);
    }


    @Override
    public E extractMin() {
        E result = elements.get(0);
        elements.set(0, elements.remove(elements.size() - 1));
        bubbleDown(0);
    }

    private void bubbleDown(int i) {
    }

    private void bubbleUp(int index) {

    }

    @Override
    public void increasePriority(E elem, P priority) {
        int index = ops.position(elem);
        bubbleUp(index);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}
