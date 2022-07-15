/** Lightly test the Rational class */
public class Main {
    public static void main(String[] args) {
        /* Above not in notes */
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        Rational c = Rational.plus(a, b);
        System.out.println(a.toString() + "+" + b + "=" + c);
        if (c.equals(new Rational(10, 12))) {
            System.out.println(" = 10/12");
        }
        /* Rest not in notes */
    }
}
