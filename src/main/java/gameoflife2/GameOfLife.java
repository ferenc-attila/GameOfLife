package gameoflife2;

public class GameOfLife {

    public static void main(String[] args) {
        Table table = new Table();
        Generation generation = new Generation();

        for (Cell cell : generation.getCells()) {
            if (cell.getY() < Table.BOUND_OF_Y/2 -1 && cell.getY() < Table.BOUND_OF_Y/2 -1 && cell.getX() == Table.BOUND_OF_X/2) {
                cell.born();
            }
        }

        table.printTable();
    }
}
