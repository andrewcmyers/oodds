interface Iterator<T> {
    boolean hasNext();
    T next() throws NoSuchElementException;
}
