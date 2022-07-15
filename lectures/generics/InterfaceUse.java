Collection<String> c = ...
c.add("hi"); // checked!
c.add(2); // illegal: static error
for (String s : c) {
    // use s
}
