/** Partition array {@code a} into {@code a[l..k)} and {@code a[k..r)},
 * where {@code l < k < r}, and all elements in {@code a[l..k)} are
 * less than or equal to all elements in {@code a[k..r)}.
 * Requires: {@code 0≤l}, {@code r≤a.length}, and {@code r-l≥2}.
 */
int partition(int[] a, int l, int r) {
    int p = a[l];
    int i = l-1, j = r;
    while (true) {
        do i++; while (a[i] < p);
        do j--; while (a[j] > p);
        if (i >= j) break;
        // swap a[i] ⇔ a[j]
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
    return j+1;
}

