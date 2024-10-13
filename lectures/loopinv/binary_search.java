/**
 * Returns: an index i such that a[i] == k.
 * Requires: k is in a, and a is sorted in ascending order
 */
int search(int[] a, int k) {
    int l = 0, r = a.length-1;
    while (l < r) {
	int m = (l+r)/2;
	if (k <= a[m]) r = m;
	else l = m+1;
    }
    return l;
}
