/** A state of the 2048 game, which contains a 4x4 grid of numeric tiles. */
interface Board {
   /**
    * Returns: the value of the tile at row r and column c, or 0 if that tile
    *   position is blank.
    * Requires: both r and c are in the range 0..3.
    */
   int tile(int r, int c);

   /** Current score */
   int score();

   /** A direction on the board */
   enum Direction {
       UP, DOWN, LEFT, RIGHT
   }

   /**
    * Effect: performs a game move in the specified direction.
    * Returns: true if the move is legal; that is, tiles can be slid in the
    *   specified direction.
    */
   boolean move(Direction d);

   /** Effect: Reset the game to the initial state, with all tiles blank. */
   void reset();
}
