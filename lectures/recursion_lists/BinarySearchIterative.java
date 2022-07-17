int search(int[] a, int k, int fst, int lst) {
   while (true) {
      if (fst == lst) return fst; // base case
      int m = (fst + lst)/2;
      if (k <= a[m])
         lst = m; // recursive call 1
      else
         fst = m + 1; // recursive call 2
    }
}
