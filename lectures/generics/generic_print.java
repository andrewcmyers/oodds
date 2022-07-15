<T> void print(Collection<T> c) {
    for (T x : c) {
        println("value: " + x);
    }
}

Collection<Integer> c;
print(c); // equivalent to this.<Integer>print(c);
