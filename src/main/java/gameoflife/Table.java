package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Table {

    public static final int BOUND_OF_X = 1000;
    public static final int BOUND_OF_Y = 1000;

    private List<Cell> cells = new ArrayList<>();

    public void addCell (Cell cell) {
        if (isInsideTable(cell)) {
            cells.add(cell);
        } else {
            throw new IllegalArgumentException("Cell is out of table");
        }
    }

    private boolean isInsideTable(Cell cell) {
        return Math.abs(cell.getX()) <= BOUND_OF_X && Math.abs(cell.getY()) <= BOUND_OF_Y;
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cells);
    }
}
