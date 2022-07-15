class Display {

   static void display(Puzzle p) {
      for (int r = 0; r < 4; r++) {
         for (int c = 0; c < 4; c++) {
            int value = p.tile(r, c);
            System.out.print(value);
         }
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      Puzzle p = new APuzzle();
      Puzzle q = new SPuzzle();
      display(p);
      System.out.println();
      display(q);
   }

}