package robot.algo;

import map.Cell;

/**
 * @author AC
 */

public class AStarGraph {

    private AStarGraph north;
    private AStarGraph northeast;
    private AStarGraph east;
    private AStarGraph southeast;
    private AStarGraph south;
    private AStarGraph southwest;
    private AStarGraph west;
    private AStarGraph northwest;

    private Cell cell;
    private int value;

    public AStarGraph (AStarGraph north, AStarGraph northeast, AStarGraph east, AStarGraph southeast, AStarGraph south,
                       AStarGraph southwest, AStarGraph west, AStarGraph northwest, Cell cell, int value) {
        this.north = north;
        this.northeast = northeast;
        this.east = east;
        this.southeast = southeast;
        this.south = south;
        this.southwest = southwest;
        this.west = west;
        this.northwest = northwest;

        this.cell = cell;
        this.value = value;
    }

    public AStarGraph getNorth() {
        return north;
    }

    public void setNorth(AStarGraph north) {
        this.north = north;
    }

    public AStarGraph getNortheast() {
        return northeast;
    }

    public void setNortheast(AStarGraph northeast) {
        this.northeast = northeast;
    }

    public AStarGraph getEast() {
        return east;
    }

    public void setEast(AStarGraph east) {
        this.east = east;
    }

    public AStarGraph getSoutheast() {
        return southeast;
    }

    public void setSoutheast(AStarGraph southeast) {
        this.southeast = southeast;
    }

    public AStarGraph getSouth() {
        return south;
    }

    public void setSouth(AStarGraph south) {
        this.south = south;
    }

    public AStarGraph getSouthwest() {
        return southwest;
    }

    public void setSouthwest(AStarGraph southwest) {
        this.southwest = southwest;
    }

    public AStarGraph getWest() {
        return west;
    }

    public void setWest(AStarGraph west) {
        this.west = west;
    }

    public AStarGraph getNorthwest() {
        return northwest;
    }

    public void setNorthwest(AStarGraph northwest) {
        this.northwest = northwest;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
