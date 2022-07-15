LList<?> f() {
    LList<Integer> i = new LList();
    i.add(2);
    i.add(3);
    i.add(5);
    return i;
}

// in caller
LList<?> lst = f();
lst.add(7); // illegal: type ? not known
for (Object o : lst) {
    println(o);
}
