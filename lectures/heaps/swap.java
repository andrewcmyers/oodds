private HeapElemOps<E, P> ops;   // element/priority operations
private E[] elems;               // the array of heap elements

private void swap(int i, int j) {
    E temp = elems[i]; elems[i] = elems[j]; elems[j] = temp;
    ops.setPosition(elems[i], i);
    ops.setPosition(elems[j], j);
}
