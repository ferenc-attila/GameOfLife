package gameoflife;

public class Population {

    private int numberOfGenerations;

    public Population(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }

    public String gameOfLife(Generation generation) {
        String actualGeneration = "";
        for (int i = 0; i < numberOfGenerations; i++) {
            actualGeneration = generation.toString();
            generation = createNextGeneration(generation);
        }
        return actualGeneration;
    }

    public Generation createNextGeneration(Generation generation) {
        Generation nextGeneration = new Generation();
        for (Cell cell : generation.getCells()) {
            if (cell.isLiving() && cell.mustDie()) {
                cell.die();
            }
            if (!cell.isLiving() && cell.canBorn()) {
                cell.born();
            }
            nextGeneration.addCell(cell);
        }
        return nextGeneration;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public void setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }

}
