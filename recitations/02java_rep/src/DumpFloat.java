class DumpFloat {

   static void dumpFloat(float f) {
      int i = Float.floatToRawIntBits(f);
      System.out.print("float " + f + " = ");
      for (int j = 31; j >= 0; j--) {
         System.out.print((i & (1 << j)) == 0 ? "0" : "1");
      }
      System.out.println("");
   }

   public static void main(String[] args) {
      float[] a = { 0.0f, 1.0f, -2.0f, 10.0f, -0.0f, 1.0e38f,
               Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN };
      for (int i = 0; i < a.length; i++) {
         dumpFloat(a[i]);
      }
      float x = 1000000.0f;
      float y = 1000000.1f;
      System.out.println("difference is" + (y - x));
      while (x > 0.0) {
         x = x / 2;
         System.out.println("Now x is " + x);
      }
   }
}
