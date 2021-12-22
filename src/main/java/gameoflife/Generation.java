package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Generation {

    private List<Cell> cells = new ArrayList<>();

    public void addCell (Cell cell) {
        if (isInsideTable(cell)) {
            cells.add(cell);
        } else {
            dropCellToOppositeSide(cell);
        }
    }

    private void dropCellToOppositeSide(Cell cell) {
        if (Math.abs(cell.getX()) > Table.BOUND_OF_X) {
            cell.setX(-1 * (Table.BOUND_OF_X - (cell.getX() - Table.BOUND_OF_X)));
        }
        if (Math.abs(cell.getY()) > Table.BOUND_OF_Y) {
            cell.setY(-1 * (Table.BOUND_OF_Y - (cell.getY() - Table.BOUND_OF_Y)));
        }
    }

    private boolean isInsideTable(Cell cell) {
        return Math.abs(cell.getX()) <= Table.BOUND_OF_X && Math.abs(cell.getY()) <= Table.BOUND_OF_Y;
    }

    @Override
    public String toString() {
        StringBuilder stringOfGeneration = new StringBuilder();
        for (int i = 0; i < Table.BOUND_OF_X; i++) {
            for (int j = 0; j < Table.BOUND_OF_Y; j++) {
                for (Cell cell : cells) {
                    if (cell.getX() == i && cell.getY() == j) {
                        stringOfGeneration.append(cell.toString());
                    }
                    if (cell.getX() == Table.BOUND_OF_X - 1) {
                        stringOfGeneration.append("\n");
                    }
                    if (cell.getX() == Table.BOUND_OF_X && cell.getY() == Table.BOUND_OF_Y) {
                        stringOfGeneration.append("\n");
                    }
                }
            }
        }
        return stringOfGeneration.toString();
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cells);
    }
}
