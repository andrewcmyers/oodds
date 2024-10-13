/**
 * Returns: an index i such that a[i] equals x.
 * Requires: x is in a, and a is sorted in ascending order
 */
int search(int[] a, int x) {
    int l = 0, r = a.length-1;
    return search_rec(a, x, l, r);
}

/**
 * Returns: an index i such that a[i] equals x.
 * Requires: 1. a is sorted in ascending order
 *           2. 0 ≤ l ≤ r < a.length
 *           3. x is in a[l..r]
 */
int search_rec(int[] a, int x, int l, int r) {
    if (l >= r) return l;
    int m = (l+r)/2;
    if (x <= a[m]) r = m;
    else l = m + 1;
    return search_rec(a, x, l, r);
}
