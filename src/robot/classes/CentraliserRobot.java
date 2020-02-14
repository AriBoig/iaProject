package robot.classes;

import map.Cell;
import map.Coordinate;
import robot.enums.Type;

import java.util.ArrayList;

/**
 * @author Enzo Dechaene
 * @author Adrien Costes
 */

public class CentraliserRobot extends Robot
{
    private double mineral;
    private double food;
    private double water;
    private double consumeWater;

    protected static ArrayList<Cell> mapExplored;

    public CentraliserRobot(Cell cell)
    {
        super(cell);
        setType(Type.CENTRALISER);
    }

    /**
     * @author AC
     * @param robot
     */
    protected static void collectInfo(Robot robot) {
        mapExplored.add(robot.getCell());
        mapExplored.add(robot.getNeighbour().getEast());
        mapExplored.add(robot.getNeighbour().getNorth());
        mapExplored.add(robot.getNeighbour().getNortheast());
        mapExplored.add(robot.getNeighbour().getNorthwest());
        mapExplored.add(robot.getNeighbour().getSouth());
        mapExplored.add(robot.getNeighbour().getSoutheast());
        mapExplored.add(robot.getNeighbour().getSouthwest());
        mapExplored.add(robot.getNeighbour().getWest());
    }

    /**
     * @author AC
     * @param coordinate
     * @return
     */
    public static Cell findByCoordinate(Coordinate coordinate) {
        int i = 0;

        if (mapExplored.size() == 0)
            return null;

        while (i < mapExplored.size()) {
            if (mapExplored.get(i).getCoordinate().equals(coordinate))
                return mapExplored.get(i);

            i++;
        }

        return null;
    }

    /**
     * @author AC
     * @param coordinate
     * @return
     */
    public static Cell removeByCoordinate(Coordinate coordinate) {
        int i = 0;

        if (mapExplored.size() == 0)
            return null;

        while (i < mapExplored.size()) {
            if (mapExplored.get(i).getCoordinate().equals(coordinate))
                return mapExplored.remove(i);

            i++;
        }

        return null;
    }

    /**
     * This method will be use by the centraliser to give orders to the robots
     * @author AC
     * @return the better road to exploit resources
     */
    protected ArrayList<Cell> aStarDirection() {
        //TODO
        return null;
    }

    /**
     * @author AC
     * @return
     */
    public double getMineral() {
        return mineral;
    }

    /**
     * @author AC
     * @return
     */
    public double getFood() {
        return food;
    }

    /**
     * @author AC
     * @return
     */
    public double getWater() {
        return water;
    }

    /**
     * @author AC
     * @return
     */
    public double getConsumeWater() {
        return consumeWater;
    }

}
