class SortedList<T> implements Collection<T> {
    Comparator<T> comparator;

    SortedList(Comparator<T> cmp) {
        comparator = cmp; // save model object
        ...
    }

    boolean add(T x) {
        ...
        if (comparator.compareTo(x, y)) { // use model object
            ...
        }
        ...
    }
}
