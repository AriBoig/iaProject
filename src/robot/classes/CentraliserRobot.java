package robot.classes;

import Game.Game;
import map.Cell;
import map.Coordinate;
import map.TypeCase;
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
    protected static ArrayList<Cell> toExplore;

    private final Object[][] poiExtractor = {{TypeCase.ORE, 5}, {TypeCase.SCREE, 2}};
    private ArrayList<Object[]> poiExtractorArr = new ArrayList<>();
    private final Object[][] poiConstructor = {{TypeCase.WATER, 5}};
    private ArrayList<Object[]> poiConstructorArr = new ArrayList<>();
    private final Object[][] poiCollector = {{TypeCase.FOOD, 5}, {TypeCase.NORMAL_MEDOW, 4},
            {TypeCase.OILY_MEDOW, 3}, {TypeCase.DRY_MEDOW, 1}};
    private ArrayList<Object[]> poiCollectorArr = new ArrayList<>();
    private final Object[][] poiFarmer = {{TypeCase.OILY_MEDOW, 5}, {TypeCase.NORMAL_MEDOW, 4}, {TypeCase.DRY_MEDOW, 2}};
    private ArrayList<Object[]> poiFarmerArr = new ArrayList<>();

    private final int[][] coordinates = {{0, 1}, {1, 1}, {1, 0}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}};

    private int nbOfRobots = 0;
    private int i = 0;
    private int importance = 0;
    private int min = Integer.MAX_VALUE;
    private int place = -1;

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

    private void toExplore() {
        toExplore.clear();

        //the most important points for the extractors
        toExplore.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.EXTRACTER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += interest(cell2, Type.EXTRACTER);
            });
            Object[] objects = {cell1, importance};

            poiExtractorArr.add(objects);
        });

        //the most important points for the constructors
        toExplore.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.CONSTRUCTER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += interest(cell2, Type.CONSTRUCTER);
            });
            Object[] objects = {cell1, importance};

            poiConstructorArr.add(objects);
        });

        //the most important points for the collectors
        toExplore.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.COLLECTER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += interest(cell2, Type.COLLECTER);
            });
            Object[] objects = {cell1, importance};

            poiCollectorArr.add(objects);
        });

        //the most important points for the farmers
        toExplore.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.FARMER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += interest(cell2, Type.FARMER);
            });
            Object[] objects = {cell1, importance};

            poiFarmerArr.add(objects);
        });
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
     * @author AC
     * @param cell1
     * @return
     */
    private ArrayList<Cell> findNeighbours(Cell cell1) {
        ArrayList<Cell> result = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i++) {
            Coordinate c = new Coordinate(cell1.getCoordinate().getX() + coordinates[i][0],
                    cell1.getCoordinate().getY() + coordinates[i][1]);
            if (findByCoordinate(c) != null) {
                result.add(findByCoordinate(c));
            }
        }

        return result;
    }

    /**
     * @author AC
     * @param cell
     * @param type
     * @return
     */
    private int interest(Cell cell, Type type) {
        switch (type) {
            case FARMER:
                for (int i = 0; i < poiFarmer.length; i++)
                    if (cell.getType() == poiFarmer[i][0])
                        return Integer.parseInt(poiFarmer[i][1].toString());

            case COLLECTER:
                for (int i = 0; i < poiCollector.length; i++)
                    if (cell.getType() == poiCollector[i][0])
                        return Integer.parseInt(poiCollector[i][1].toString());

            case EXTRACTER:
                for (int i = 0; i < poiExtractor.length; i++)
                    if (cell.getType() == poiExtractor[i][0])
                        return Integer.parseInt(poiExtractor[i][1].toString());

            case CONSTRUCTER:
                for (int i = 0; i < poiConstructor.length; i++)
                    if (cell.getType() == poiConstructor[i][0])
                        return Integer.parseInt(poiConstructor[i][1].toString());
        }

        return 0;
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

}
