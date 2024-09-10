class ABoard implements Board {
   /** Representation: tiles[r][c] contains the value of the tile
    *    at row r and column c, or 0 if there is no tile.
    *  Invariant: tiles is a 4x4 array that contains only 0 or powers
    *    of two.
    */
   private int[][] tiles; // a 4x4 array
   private int score;

   public ABoard() {
      reset();
   }

   public void reset() {
      tiles = new int[4][4];
   }

   public int tile(int r, int c) {
      return tiles[r][c];
   }

   public boolean move(char d) {
      switch (d) {
        case UP:
          // code to move up
          break;
        case DOWN:
          // code to move down
          break;
        case RIGHT:
          // code to move right
          break;
        case LEFT:
          // code to move left
          break;
      }
      return true;
   }

   public int score() {
      return score;
   }
}
