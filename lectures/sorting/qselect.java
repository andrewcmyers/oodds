/**
 * Returns: the (n-l)th smallest element in the subarray {@code a[l..r)}
 * Requires: {@code 0 ≤ l ≤ n < r ≤ a.length}
 */
int qselect(int[] a, int l, int r, int n) {
   if (r - l == 1) return a[l];
   int k = partition(a, l, r);
   if (n < k) return qselect(a, l, k, n);
   else return qselect(a, k, r, n - k);
}
