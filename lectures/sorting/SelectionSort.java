int n = a.length;
for (int i = 0; i < n-1; i++) {
    // loop invariant:
    //    1. 0 ≤ i ≤ n-1
    //    2. a[0..i) contains the smallest i elements in a, in sorted order.
    //    3. a contains a permutation of the original sequence of elements in a

    // find smallest element k = a[p] in subarray a[i..n-1)
    int k = a[i], p = i;
    for (int j = i+1; j < n; j++) {
        if (a[j] < k) {
            k = a[j];
            p = j;
        }
    }
    // swap a[i] and a[p]
    a[p] = a[i];
    a[i] = k;
}

