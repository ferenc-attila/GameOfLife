package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private boolean living;
    private final int x;
    private final int y;
    private List<Cell> neighbours = new ArrayList<>(8);

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLiving() {
        return living;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addExistingNeighbours(Table table) {
        for (Cell cell : table.getCells()) {
            if (cell.isNeighbour(this)) {
                neighbours.add(cell);
            }
        }
    }

    private boolean isNeighbour(Cell cell) {
        return (cell.calculateDistance(this) == 1);
    }

    private int calculateDistance(Cell cell) {
        return (int)(Math.round(Math.sqrt(Math.pow((double)this.x - cell.getX(), 2) + Math.pow((double)this.y - cell.getY(), 2))));
    }

    public void die() {
        if (isLiving()) {
            living = false;
        }
    }

    public void born() {
        if (!isLiving()) {
            living = true;
        }
    }

    public void createNextGeneration() {
        int livingNeighbours = 0;
        for (Cell cell : neighbours) {
            if (cell.isLiving()) {
                livingNeighbours++;
            }
        }
        if (livingNeighbours != 2 && livingNeighbours !=3) {
            this.die();
        }
    }
}
