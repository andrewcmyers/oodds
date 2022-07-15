/**
 * A rational number p/q where p is the numerator and q is the denominator
 */
public class Rational {
    private int p,q; // represents p/q
    // class invariant: q > 0, gcd(p, q) = 1
    //                  Note: gcd(0, x) = x

    /** Create num/den. Requires den != 0. */
    public Rational(int num, int den) {
        if (den < 0) {
            num = -num;
            den = -den;
        }
        int g = gcd(num, den);
        p = num/g;
        q = den/g;
    }

    /** Update this to be this + r */
    public void add(Rational r) {
        int g = gcd(q, r.q);
        p = r.q/g * p + q/g * r.p;
        q *= r.q/g;
    }

    /** Returns x + y */
    public static Rational plus(Rational x, Rational y) {
        Rational z = new Rational(x.p, x.q);
        z.add(y);
        return z;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Rational)) return false;
        Rational r = (Rational) o;
        return (p == r.p && q == r.q);
    }
    public String toString() {
        return Integer.toString(p) + "/" + q;
    }

    /* Begin ... in notes */
    /** The greatest common divisor of x and y */
    private static int gcd(int x, int y) {
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        while (y != 0) {
            if (x > y) {
                int t = y;
                y = x;
                x = t;
            } else {
                y = y % x;
            }
        }
        return x;
    }
    /* End ... */
}
