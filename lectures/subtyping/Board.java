/** A state of the 2048 game, which contains a 4x4 grid of numeric tiles. */
interface Board {
   
   /** Reset the game to the initial state, with all tiles blank. */
   void reset();

   /**
    * Returns: the value of the tile at row r and column c, or 0 if that tile
    * position is blank. Checks: both r and c are in the range 0..3.
    */
   int tile(int r, int c);

   /**
    * Effect: performs a game move in the specified direction. Returns: true if
    * the move is legal; that is, tiles can be slid in the specified direction.
    * Checks: {@code d} is one of 'N', 'S', 'E', or 'W'.
    */
   boolean move(char d);

   /** Current score. */
   int score();
}
