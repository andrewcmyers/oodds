Random r = new Random(); // the source of randomness

<T> void shuffle(T[] a) {
   for (int i = a.length-1; i > 0; i--) {
       int j = r.nextInt(i+1);
       // swap a[j] and a[i]
       T temp = a[j];
       a[j] = a[i];
       a[i] = temp;
   }
}
