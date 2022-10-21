Maybe<String> m = ...;
try {
  System.out.println("The string is " + m.get());
} catch (NoMaybeValue exc) {
  System.out.println("No string");
}
