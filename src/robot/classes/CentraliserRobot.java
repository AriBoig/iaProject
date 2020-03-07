package robot.classes;

import map.Cell;
import map.Coordinate;
import map.TypeCase;
import robot.enums.Mode;
import robot.enums.Type;

import java.util.ArrayList;

/**
 * @author ED
 * @author Adrien Costes
 */

public class CentraliserRobot extends Robot
{
    private double mineral;
    private double food;
    private double water;
    private double consumeWater;

    public static ArrayList<Cell> mapExplored;

    public static final Object[][] poiExtractor = {{TypeCase.ORE, 5}, {TypeCase.SCREE, 2}};
    public static final Object[][] poiConstructor = {{TypeCase.WATER, 5}};
    public static final Object[][] poiCollector = {{TypeCase.FOOD, 5}, {TypeCase.NORMAL_MEADOW, 4},
            {TypeCase.OILY_MEADOW, 3}, {TypeCase.DRY_MEADOW, 1}};
    public static final Object[][] poiFarmer = {{TypeCase.OILY_MEADOW, 5}, {TypeCase.NORMAL_MEADOW, 4}, {TypeCase.DRY_MEADOW, 2}};

    public static final int[][] coordinates = {{0, 1}, {1, 1}, {1, 0}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}};

    private int min = Integer.MAX_VALUE;
    private int place = -1;

    public CentraliserRobot(Cell cell)
    {
        super(cell);

        mineral = 0;
        food = 0;
        water = 0;
        consumeWater = 0;
        action = Mode.NOTHING;
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

    private int findMinimumInterest(ArrayList<Object[]> objects) {

        objects.forEach(objects1 -> {
            if (min != Math.min(Integer.parseInt(objects1[1].toString()), min)) {
                min = Math.min(Integer.parseInt(objects1[1].toString()), min);
                place++;
            }
        });

        return place;
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

    /**
     * @author ED
     * @param consumeWater
     */
    public void setConsumeWater(double consumeWater) {
        this.consumeWater = consumeWater;
    }
}
