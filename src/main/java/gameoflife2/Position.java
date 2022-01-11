package gameoflife2;

public class Position {

    private int yCoordinate;
    private int xCoordinate;

    public Position(int yCoordinate, int xCoordinate) {
        validateCoordinates(yCoordinate, xCoordinate);
        this.yCoordinate = yCoordinate;
        this.xCoordinate = xCoordinate;
    }

    private void validateCoordinates(int yCoordinate, int xCoordinate) {
        if (yCoordinate < 0 || yCoordinate > Table.BOUND_OF_Y || xCoordinate < 0 || xCoordinate > Table.BOUND_OF_X) {
            throw new IllegalArgumentException("Coordinates (" + yCoordinate + ";" + xCoordinate + ") are invalid!");
        }
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }
}
