/** Returns: an index i between indices first and last, inclusive,
             such that a[i] = x.
    Requires: such an index exists, and a is sorted in ascending order.
 */
int search(int[] a, int x, int first, int last) {
   if (first == last) return first; // base case
   int m = (first + last)/2;
   if (x <= a[m])
      last = m;
   else
      first = m+1;
   return search(a, x, first, last);
}
