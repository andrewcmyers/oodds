class Pow {
/* Above not in notes */
    /**
     *  Returns: x^e
     *  Requires: e ≥ 0
     *  Performance: O(log e)
     */
    static int pow(int x, int e) {
        int r = 1, b = x, y = e;
        // loop invariant: r·b^y = x^e  and  y ≥ 0
        while (y > 0) {
            if (y % 2 == 1) r = r*b;
            y = y/2;
            b = b*b;
        }
        return r;
    }
/* Rest not in notes */
}
