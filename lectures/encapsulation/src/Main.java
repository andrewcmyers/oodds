/** Lightly test the Rational class */
public class Main {
    public static void main(String[] args) {
        /* Above not in notes */
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        Rational c = Rational.plus(a, b);
        System.out.println(a.toString() + "+" + b + "=" + c);
            // prints "1/2 + 1/3 = 5/6"
        if (c.equals(new Rational(10, 12))) {
            System.out.println(" = 10/12");
            // prints "= 10/12"
        }
        /* Rest not in notes */
    }
}
