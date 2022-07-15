class InsertionSort {
/* Above not in notes */
    /** Effect: Put a into ascending sorted order. */
    void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int k = a[i];
            int j = i;
            for (; j > 0 && a[j-1] > k; j--)
                a[j] = a[j-1];
            a[j] = k;
        }
    }
/* Rest not in notes */
}
