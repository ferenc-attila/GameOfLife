package gameoflife2;

import gameoflife.Generation;
import gameoflife.Table;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private boolean living;
    private int x;
    private int y;
    private List<Cell> neighbours = new ArrayList<>(8);

    public Cell(boolean living, int x, int y) {
        this.living = living;
        this.x = x;
        this.y = y;
    }

//    public void addExistingNeighbours(Generation generation) {
//        for (Cell cell : generation.getCells()) {
//            if (cell.isNeighbour(this) || cell.isNeighbourOppositeSide(this)) {
//                neighbours.add(cell);
//            }
//        }
//    }

    private boolean isNeighbour(Cell cell) {
        return (cell.calculateDistance(this) == 1);
    }

    private int calculateDistance(Cell cell) {
        return (int)(Math.round(Math.sqrt(Math.pow((double)this.x - cell.getX(), 2) + Math.pow((double)this.y - cell.getY(), 2))));
    }

    private boolean isNeighbourOppositeSide(Cell cell) {
        if (Math.abs(this.x) == gameoflife.Table.BOUND_OF_X && cell.getX() == -1 * this.x && this.y >= cell.getY() - 1 && this.y <= cell.getY() + 1) {
            return true;
        }
        return (Math.abs(this.y) == Table.BOUND_OF_Y && cell.getY() == -1 * this.y && this.x >= cell.getX() - 1 && this.x <= cell.getX() + 1);
    }

    public void die() {
        this.living = false;
    }

    public void born() {
        this.living = true;
    }

    public boolean mustDie() {
        return isLiving() && (getNumberOfLivingNeighbours() < 2 || getNumberOfLivingNeighbours() > 3);
    }

    public boolean canBorn() {
        return !isLiving() && (getNumberOfLivingNeighbours() == 3);
    }

    public int getNumberOfLivingNeighbours() {
        int livingNeighbours = 0;
        for (Cell cell: neighbours) {
            if (cell.isLiving()) {
                livingNeighbours++;
            }
        }
        return livingNeighbours;
    }

    @Override
    public String toString() {
        if (living) {
            return "|*|";
        }
        return "| |";
    }

    public boolean isLiving() {
        return living;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Cell> getNeighbours() {
        return new ArrayList<>(neighbours);
    }
}
