class InsertionSort {
  /** Effect: Put a into ascending sorted order. */
  void sort(int[] a) {
/* Above not in notes */
   for (int i = 1; i < a.length; i++) {
       // loop invariant:
       //    1. 1 ≤ i ≤ a.length
       //    2. a[0..i) is sorted in ascending order
       //    3. a contains a permutation of the original sequence of elements in a
       int k = a[i];
       int j = i;
       for (; j > 0 && a[j-1] > k; j--) {
           a[j] = a[j-1];
       }
       a[j] = k;
   }
/* Rest not in notes */
  }
}
