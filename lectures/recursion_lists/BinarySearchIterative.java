int search(int[] a, int x, int first, int last) {
   while (true) {
      if (first == last) return first; // base case
      int m = (first + last)/2; // recursive case
      if (x <= a[m])
         last = m; 
      else
         first = m + 1;
   }
}
