class SBoard implements Board {
   /** Representation: the character values in the string give the
    *    values of the corresponding tiles.
    *  Invariant: tiles.length() is 16
    */
   private String tiles;
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

   public boolean move(Direction d) {
      //code to move the tiles in direction d
      return true;
   }

   public int score() {
      return score;
   }
}
