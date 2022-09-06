class SBoard implements Board {
   
   private String tiles; // a 16-character string
   private int score;

   public SBoard() {
      reset();
   }

   public void reset() {
     tiles = "\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";
   }

   public int tile(int r, int c) {
      assert 0 <= r && r < 4 && 0 <= c && c < 4;
      return tiles.charAt(r * 4 + c);
   }

   public boolean move(char d) {
      //code to move the tiles in direction d
      return true;
   }

   public int score() {
      return score;
   }
}
