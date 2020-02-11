package robot.classes;

import map.Cell;
import map.Coordinate;

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

    private ArrayList<Cell> mapExplored;


    public CentraliserRobot()
    {
        super();
    }

    /**
     * @author AC
     * @param robot
     */
    public void collectInfo(Robot robot) {
        getMapExplored().add(robot.getCell());
        getMapExplored().add(robot.getNeighbour().getEast());
        getMapExplored().add(robot.getNeighbour().getNorth());
        getMapExplored().add(robot.getNeighbour().getNortheast());
        getMapExplored().add(robot.getNeighbour().getNorthwest());
        getMapExplored().add(robot.getNeighbour().getSouth());
        getMapExplored().add(robot.getNeighbour().getSoutheast());
        getMapExplored().add(robot.getNeighbour().getSouthwest());
        getMapExplored().add(robot.getNeighbour().getWest());
    }

    /**
     * @author AC
     * @param coordinate
     * @return
     */
    public Cell findByCoordinate(Coordinate coordinate) {
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

    /**
     * @author AC
     * @return
     */
    public ArrayList<Cell> getMapExplored() {
        return mapExplored;
    }

}
