/** Returns: an index i between indices fst and lst, inclusive, where
    a[i] == k. Requires: that such an index exists, and that a is
	sorted in ascending order.
 */
int search(int[] a, int k, int fst, int lst) {
   if (fst == lst) return fst; // base case
   int m = (fst + lst)/2;
   if (k <= a[m])
      return search(a, k, fst, m);
   else
      return search(a, k, m+1, lst);
}
