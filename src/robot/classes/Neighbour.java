package robot.classes;

import display.main.MainClass;
import map.Cell;
import map.Coordinate;
import map.TypeCase;

/**
 * @author ED
 * @author AC
 */
public class Neighbour
{
    public Cell north;
    public Cell south;
    public Cell east;
    public Cell west;
    public Cell northeast;
    public Cell northwest;
    public Cell southeast;
    public Cell southwest;

    public Neighbour(Cell current) {
        cellInit(current);
    }
    
    public boolean findWater()
    {
        return (north.getType() == TypeCase.WATER || south.getType() == TypeCase.WATER ||
                east.getType() == TypeCase.WATER || west.getType() == TypeCase.WATER ||
                northeast.getType() == TypeCase.WATER || northwest.getType() == TypeCase.WATER ||
                southeast.getType() == TypeCase.WATER || southwest.getType() == TypeCase.WATER);
    }

    /**
     * @author AC
     * @param current
     */
    private void cellInit(Cell current) {

        //TODO récupérer le type des cases dans le gameboard

        Coordinate coordinate = new Coordinate(current.getCoordinate().getX(), current.getCoordinate().getY() + 1);
        getNorth().setCoordinate(coordinate);
        getNorth().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX() + 1, current.getCoordinate().getY());
        getEast().setCoordinate(coordinate);
        getEast().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX() + 1, current.getCoordinate().getY() + 1);
        getNortheast().setCoordinate(coordinate);
        getNortheast().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX() - 1, current.getCoordinate().getY() + 1);
        getNorthwest().setCoordinate(coordinate);
        getNorthwest().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX(), current.getCoordinate().getY() - 1);
        getWest().setCoordinate(coordinate);
        getWest().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX() + 1, current.getCoordinate().getY() - 1);
        getNorthwest().setCoordinate(coordinate);
        getNorthwest().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX() - 1, current.getCoordinate().getY() - 1);
        getNorthwest().setCoordinate(coordinate);
        getNorthwest().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

        coordinate = new Coordinate(current.getCoordinate().getX() - 1, current.getCoordinate().getY());
        getNorthwest().setCoordinate(coordinate);
        getNorthwest().setType(MainClass.getGameboard().getGameboard()[coordinate.getY()][coordinate.getX()].getType());

    }

    /**
     * @author AC
     * @return
     */
    public Cell getNorth() {
        return north;
    }

    /**
     * @author AC
     * @return
     */
    public void setNorth(Cell north) {
        this.north = north;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getSouth() {
        return south;
    }

    /**
     * @author AC
     * @return
     */
    public void setSouth(Cell south) {
        this.south = south;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getEast() {
        return east;
    }

    /**
     * @author AC
     * @return
     */
    public void setEast(Cell east) {
        this.east = east;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getWest() {
        return west;
    }

    /**
     * @author AC
     * @return
     */
    public void setWest(Cell west) {
        this.west = west;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getNortheast() {
        return northeast;
    }

    /**
     * @author AC
     * @return
     */
    public void setNortheast(Cell northeast) {
        this.northeast = northeast;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getNorthwest() {
        return northwest;
    }

    /**
     * @author AC
     * @return
     */
    public void setNorthwest(Cell northwest) {
        this.northwest = northwest;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getSoutheast() {
        return southeast;
    }

    /**
     * @author AC
     * @return
     */
    public void setSoutheast(Cell southeast) {
        this.southeast = southeast;
    }

    /**
     * @author AC
     * @return
     */
    public Cell getSouthwest() {
        return southwest;
    }

    /**
     * @author AC
     * @return
     */
    public void setSouthwest(Cell southwest) {
        this.southwest = southwest;
    }
}
