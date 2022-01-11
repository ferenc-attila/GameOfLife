package gameoflife2;

import gameoflife.Cell;
import gameoflife.Generation;
import gameoflife.Table;

public class GameOfLife {

    public static void main(String[] args) {
        Table table = new Table();
        Generation generation = new Generation();
        generation.addCell(new Cell(true, Table.BOUND_OF_Y/2, Table.BOUND_OF_X/2));

        table.printTable();
    }
}
