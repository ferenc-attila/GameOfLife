package gameoflife2;

import gameoflife.Cell;
import gameoflife.Generation;

public class Table {

    public static final int BOUND_OF_X = 200;
    public static final int BOUND_OF_Y = 15;

    private char[][] grid = new char[BOUND_OF_Y][BOUND_OF_X];
    private gameoflife.Generation generation = new Generation();

    public Table() {
        createEmptyGeneration();
        createBorders();
        createGeneration();
    }

    private void createEmptyGeneration() {
        for (int y = 0; y < BOUND_OF_Y; y++) {
            for (int x = 0; x < BOUND_OF_X; x++) {
                generation.addCell(new Cell(false, x, y));
            }
        }
    }

    private void createBorders() {
        for (int y = 0; y < BOUND_OF_Y; y++) {
            for (int x = 0; x < BOUND_OF_X; x++) {
                generation.addCell(new Cell(false, x, y));
                if (x == 1 || x == (BOUND_OF_X - 1)) {
                    grid[y][x] = '|';
                } else if (y == 0 || y == (BOUND_OF_Y - 1)) {
                    grid[y][x] = '_';
                } else {
                    grid[y][x] = ' ';
                }
            }
        }
    }

    private void createGeneration() {
        for (Cell cell : generation.getCells()) {
            if (cell.isLiving()) {
                grid[cell.getY()][cell.getX()] = '*';
            }
        }
    }

    public void printTable() {
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.print("\n");
        }
    }

    public char[][] getGrid() {
        return grid;
    }
}
