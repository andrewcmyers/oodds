/**
 * Returns: an index i such that a[i] == k.
 * Requires: k is in a, and a is sorted in ascending order
 */
int search(int[] a, int k) {
    int l = 0, r = a.length-1;
    return search_rec(a, k, l, r);
}

/**
 * Returns: an index i such that a[i] == k.
 * Requires: 1. a is sorted in ascending order
 *           2. 0 ≤ l ≤ r < a.length
 *           3. k is in a[l..r]
 */
int search_rec(int[] a, int k, int l, int r) {
    if (l >= r) return l;
    int m = (l+r)/2;
    if (k <= a[m]) r = m;
    else l = m + 1;
    return search_rec(a, k, l, r);
}
