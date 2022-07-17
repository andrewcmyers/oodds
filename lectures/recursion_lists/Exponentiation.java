public class Exponentiation {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: Main <n>\n");
		} else {
			System.out.println("2^" + args[0] + "=" + pow(2, Integer.parseInt(args[0])));
		}
	}
/* Above not in notes */
   /** Returns x^e. Requires e≥0 and the result is representable as an int. */
   static int pow(int x, int e) {
      if (e == 0) return 1;
      int h = pow(x, e/2);
      if (e%2 == 0) return h*h;
      return h*h*x;
   }
/* Rest not in notes */
}
