/** Partition array {@code a} into {@code a[l..k)} and {@code a[k..r)},
 * where {@code l < k < r}, and all elements in {@code a[l..k)} are
 * less than or equal to all elements in {@code a[k..r)}.
 * Requires: {@code 0≤l}, {@code r≤a.length}, and {@code r-l≥2}.
 */
int partition(int[] a, int l, int r) {
    swap(a, l, l + random.nextInt(r-l));
    int p = a[l];
    int i = l, j = r - 1;
    while (a[j] > p) j--;
    while (i < j) {
        swap(a, i, j); // swap a[i] and a[j]
        do i++; while (a[i] < p);
        do j--; while (a[j] > p);
    }
    return j+1;
}

