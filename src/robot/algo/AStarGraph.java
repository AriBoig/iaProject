package robot.algo;

import Game.Game;
import display.main.MainClass;
import map.Cell;
import map.Coordinate;
import robot.classes.Neighbour;

/**
 * @author AC
 */

public class AStarGraph {

    protected static AStarGraph root = new AStarGraph(MainClass.getgb().getCenterCell(), 0);

    private Cell cell;
    private Neighbour neighbour;
    private int value;
    private AStarGraph[] sons = new AStarGraph[8];

    private AStarGraph (Cell cell, int value) {
        this.neighbour = new Neighbour(cell);
        this.cell = cell;
        this.value = value;
    }

    private AStarGraph initGraph(AStarGraph aStarGraph) {

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 0);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 1);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 2);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 3);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 4);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 5);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 6);
            return initGraph(aStarGraph1);
        }

        //north
        if (aStarGraph.getNeighbour().getNorth() != null) {
            Cell north = aStarGraph.getNeighbour().getNorth();
            AStarGraph aStarGraph1 = new AStarGraph(north, aStarGraph.getValue() + 1);
            aStarGraph1.getNeighbour().setSouth(null);
            aStarGraph.setSons(aStarGraph1, 7);
            return initGraph(aStarGraph1);
        }

        return null;
    }

    public static AStarGraph findNode(AStarGraph aStarGraph, Coordinate coordinate) {
        for (AStarGraph son : aStarGraph.getSons()) {
            if (son.getCell().equals(coordinate))
                return son;
            
        }
        return null;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Neighbour getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AStarGraph[] getSons() {
        return sons;
    }

    public void setSons(AStarGraph sons, int i) {
        this.sons[i] = sons;
    }
}
