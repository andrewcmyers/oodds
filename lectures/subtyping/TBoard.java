public class TBoard implements Board {
    /** Representation: tiles[i] where 0 <= i < numTiles describes a tile
     *    at row tiles[i][0], column tiles[i][1], with value tiles[i][2]
     *  Invariant: tiles is a 16x3 array, all tile descriptions are legal
     *    and all tiles are in different positions.
     */
    private int[][] tiles = new int[16][3];
    private int numTiles;
    private int score = 0;

    public void reset() {
        score = 0;
        numTiles = 0;
    }
    public int tile(int r, int c) {
        for (int i = 0; i < numTiles; i++) {
            if (r == tiles[i][0] && c == tiles[i][1])
                return tiles[i][2];
        }
        return 0;
    }

    @Override
    public int score() {
        return score;
    }
}
