/**
 * Effect: put array a into ascending sorted order
 */
void sort(int[] a) {
    // loop invariant:
    //     1 ≤ i ≤ a.length
    //     a[0..i-1] is in sorted order
    // Decrementing function: a.length - i
    for (int i = 1; i < a.length; i++) {
        int k = a[i];
        // loop invariant:
        //   0 ≤ j ≤ i < a.length
        //   Elements a[0..i], excluding a[j], are in sorted order,
        //     and include all the elements found originally in a[0..i-1].
        //   Elements a[j+1..i] > k.
        // Decrementing function: j-1
        for (int j = i; j > 0 && a[j-1] > k; j--) {
            a[j] = a[j-1];
        }
        a[j] = k;
    }
}
