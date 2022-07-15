public class Room {

    public static void main(String[] args) {
        makeSquareRoom(-2);
        makeSquareRoomWithFinally(-2);
    }

    /**
     * The number of rows of seats.
     */
    final int numRows;

    /**
     * The number of seats in each row.
     */
    final int numCols;

    /**
     * The names of people seated at each seat in this Room, represented by row,
     * then by column. Null represents an empty seat.
     */
    String[][] people;

    /**
     * Constructor: a Room with n rows and m columns of seats.
     *
     * @param n Number of rows of seats
     * @param m Number of columns of seats
     * @throws IllegalArgumentException if n or m are negative
     */
    public Room(int n, int m) throws IllegalArgumentException {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException();
        }
        people = new String[n][m];
        numRows = n;
        numCols = m;
    }


    /**
     * Returns: Room with a rows and a columns of seats, or an empty room if a is negative.
     *
     * @param a Number of rows and columns of seats
     */
    public static Room makeSquareRoom(int a) {
        try {
            return new Room(a, a);
        } catch (IllegalArgumentException e) {
            System.err.println("Cannot create negative rows! Returning empty room instead.");
            return new Room(0, 0);
        }
    }

    /**
     * Returns: room with a rows and a columns of seats, or an empty room if a is negative.
     *
     * @param a Number of rows and columns of seats
     */
    public static Room makeSquareRoomWithFinally(int a) {
        try {
            return new Room(a, a);
        } catch (IllegalArgumentException e) {
            System.err.println("Cannot create negative rows! Returning empty room instead.");
            return new Room(0, 0);
        } finally {
            System.out.println("Room created!");
        }
    }

}
