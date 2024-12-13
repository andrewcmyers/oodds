/**
 * Returns: the (n-l)th smallest element in the subarray {@code a[l..r)}
 * Requires: {@code 0 ≤ l ≤ n < r ≤ a.length}
 */
int qselect(int[] a, int l, int r, int n) {
    while (r-l >= 2) {
        int k = partition(a, l, r);
        if (n < k) {
            r = k;
        } else {
            n -= k - l;
            l = k;
        }
    }
    return a[l];
}
