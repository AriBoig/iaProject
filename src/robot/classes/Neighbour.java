package robot.classes;

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
        Cell cur = current;

        //TODO récupérer le type des cases dans le gameboard

        Coordinate coordinate = new Coordinate(current.getCoordinate().getX(), current.getCoordinate().getY() + 1);
        cur.setCoordinate(coordinate);
        setNorth(cur);

        coordinate = new Coordinate(current.getCoordinate().getX() + 1, current.getCoordinate().getY());
        cur.setCoordinate(coordinate);
        setEast(cur);

        coordinate = new Coordinate(current.getCoordinate().getX() + 1, current.getCoordinate().getY() + 1);
        cur.setCoordinate(coordinate);
        setNortheast(cur);

        coordinate = new Coordinate(current.getCoordinate().getX() - 1, current.getCoordinate().getY() + 1);
        cur.setCoordinate(coordinate);
        setNorthwest(cur);

        coordinate = new Coordinate(current.getCoordinate().getX(), current.getCoordinate().getY() - 1);
        cur.setCoordinate(coordinate);
        setSouth(cur);

        coordinate = new Coordinate(current.getCoordinate().getX() + 1, current.getCoordinate().getY() - 1);
        cur.setCoordinate(coordinate);
        setSoutheast(cur);

        coordinate = new Coordinate(current.getCoordinate().getX() - 1, current.getCoordinate().getY() - 1);
        cur.setCoordinate(coordinate);
        setSouthwest(cur);

        coordinate = new Coordinate(current.getCoordinate().getX() - 1, current.getCoordinate().getY());
        cur.setCoordinate(coordinate);
        setWest(cur);

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
