package robot.classes;

import display.main.MainClass;
import map.Cell;
import map.TypeCase;
import robot.enums.Direction;

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
        north     = null;
        northeast = null;
        northwest = null;
        south     = null;
        southeast = null;
        southwest = null;
        east      = null;
        west      = null;

        cellInit(current);
    }
    

    /**
     *
     * @return
     * @author Enzo DECHAENE
     */
    public boolean findWater()
    {
        return (north != null && north.getType() == TypeCase.WATER) || (south != null && south.getType() == TypeCase.WATER)
                || (east != null && east.getType() == TypeCase.WATER) || (west != null && west.getType() == TypeCase.WATER)
                || (northeast != null && northeast.getType() == TypeCase.WATER) || (northwest != null &&
                northwest.getType() == TypeCase.WATER) || (southeast != null && southeast.getType() == TypeCase.WATER)
                || (southwest != null && southwest.getType() == TypeCase.WATER);
    }

    /**
     *
     * @author AC & ED
     * @param current
     */
    private void cellInit(Cell current)
    {
        int x = current.getCoordinate().getX();
        int y = current.getCoordinate().getY();
        Cell[][] cell = MainClass.getgb().getGameboard();

        if (!current.isTop()) {
            north = cell[y][x-1];
            if (!current.isRight())
                northeast =  cell[y+1][x-1];
            if (!current.isLeft())
                northwest =  cell[y-1][x-1];
        }

        if (!current.isBottom()) {
            south = cell[y][x+1];
            if (!current.isRight())
                southeast = cell[y+1][x+1];
            if (!current.isLeft())
                southwest = cell[y-1][x+1];
        }

        if (!current.isRight()) {
            east = cell[y+1][x];
            if (!current.isTop())
                northeast = cell[y+1][x-1];
            if (!current.isBottom())
                southeast = cell[y+1][x+1];
        }

        if (!current.isLeft()) {
            west = cell[y-1][x];
            if (!current.isTop())
                northwest = cell[y-1][x-1];
            if (!current.isBottom())
                southwest = cell[y-1][x+1];
        }
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

    /**
     *
     * @param direction
     * @return
     * @author Enzo DECHAENE
     */
    public Cell findCellByDirection(Direction direction)
    {
        Cell cell = null;

        switch (direction) {
            case NORTH:     cell = north;     break;
            case SOUTH:     cell = south;     break;
            case EAST:      cell = east;      break;
            case WEST:      cell = west;      break;
            case NORTHEAST: cell = northeast; break;
            case NORTHWEST: cell = northwest; break;
            case SOUTHEAST: cell = southeast; break;
            case SOUTHWEST: cell = southwest; break;
            default: cell = null;
        }

        return cell;
    }

    /**
     *
     * @param cell
     * @author Enzo DECHAENE
     */
    public void updateNeighbour(Cell cell)
    {
        // TODO actualiser les cellules avec la cellule passe en parametre
    }

    @Override
    public String toString() {
        return "Neighbour{" +
                "north=" + north +
                ", south=" + south +
                ", east=" + east +
                ", west=" + west +
                ", northeast=" + northeast +
                ", northwest=" + northwest +
                ", southeast=" + southeast +
                ", southwest=" + southwest +
                '}';
    }
}
