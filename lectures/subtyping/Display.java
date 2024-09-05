class Display {

   static void display(Board p) {
      for (int r = 0; r < 4; r++) {
         for (int c = 0; c < 4; c++) {
            int value = p.tile(r, c);
            System.out.print(value);
         }
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      Board p = new ABoard();
      Board q = new TBoard();
      Board r = new SBoard();
      display(p);
      display(q);
      display(r);
   }

}
