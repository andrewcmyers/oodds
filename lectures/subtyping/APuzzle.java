class APuzzle implements Puzzle {
   
   private int[][] tiles; // a 4x4 array
   private int score;

   public APuzzle() {
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
      case 'N': // code to move north
      case 'S': // code to move south
      case 'E': // code to move east
      case 'W': // code to move west
      default:
         assert false;
      }
      return true;
   }

   public int score() {
      return score;
   }
}
