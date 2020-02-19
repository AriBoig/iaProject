package robot.algo;

import Game.Game;
import map.Cell;
import map.Coordinate;
import robot.classes.CentraliserRobot;
import robot.enums.Type;

import java.util.ArrayList;

/**
 * @author AC
 */

public class Astar {

    private int nbOfRobots = 0;
    private int i = 0;
    private int importance = 0;

    private ArrayList<Object[]> poiExtractorArr = new ArrayList<>();
    private ArrayList<Object[]> poiCollectorArr = new ArrayList<>();
    private ArrayList<Object[]> poiConstructorArr = new ArrayList<>();
    private ArrayList<Object[]> poiFarmerArr = new ArrayList<>();

    /**
     * @author AC
     * @param cell
     * @param type
     * @return
     */
    protected static int heuristic(Cell cell, Type type) {
        switch (type) {
            case FARMER:
                for (int i = 0; i < CentraliserRobot.poiFarmer.length; i++)
                    if (cell.getType() == CentraliserRobot.poiFarmer[i][0])
                        return Integer.parseInt(CentraliserRobot.poiFarmer[i][1].toString());

            case COLLECTER:
                for (int i = 0; i < CentraliserRobot.poiCollector.length; i++)
                    if (cell.getType() == CentraliserRobot.poiCollector[i][0])
                        return Integer.parseInt(CentraliserRobot.poiCollector[i][1].toString());

            case EXTRACTER:
                for (int i = 0; i < CentraliserRobot.poiExtractor.length; i++)
                    if (cell.getType() == CentraliserRobot.poiExtractor[i][0])
                        return Integer.parseInt(CentraliserRobot.poiExtractor[i][1].toString());

            case CONSTRUCTER:
                for (int i = 0; i < CentraliserRobot.poiConstructor.length; i++)
                    if (cell.getType() == CentraliserRobot.poiConstructor[i][0])
                        return Integer.parseInt(CentraliserRobot.poiConstructor[i][1].toString());
        }

        return 0;
    }

    private void toExplore() {

        //the most important points for the extractors
        CentraliserRobot.mapExplored.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.EXTRACTER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += heuristic(cell2, Type.EXTRACTER);
            });
            Object[] objects = {cell1, importance};

            poiExtractorArr.add(objects);
            importance = 0;
        });

        //the most important points for the constructors
        CentraliserRobot.mapExplored.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.CONSTRUCTER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += heuristic(cell2, Type.CONSTRUCTER);
            });
            Object[] objects = {cell1, importance};

            poiConstructorArr.add(objects);
            importance = 0;
        });

        //the most important points for the collectors
        CentraliserRobot.mapExplored.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.COLLECTER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += heuristic(cell2, Type.COLLECTER);
            });
            Object[] objects = {cell1, importance};

            poiCollectorArr.add(objects);
            importance = 0;
        });

        //the most important points for the farmers
        CentraliserRobot.mapExplored.forEach(cell1 -> {
            Game.robots.forEach(robot -> {
                if (robot.getType().equals(Type.FARMER)) {
                    nbOfRobots++;
                }
            });

            findNeighbours(cell1).forEach(cell2 -> {
                importance += heuristic(cell2, Type.FARMER);
            });
            Object[] objects = {cell1, importance};

            poiFarmerArr.add(objects);
            importance = 0;
        });
    }

    /**
     * @author AC
     * @param cell1
     * @return
     */
    private ArrayList<Cell> findNeighbours(Cell cell1) {
        ArrayList<Cell> result = new ArrayList<>();

        for (int i = 0; i < CentraliserRobot.coordinates.length; i++) {
            Coordinate c = new Coordinate(cell1.getCoordinate().getX() + CentraliserRobot.coordinates[i][0],
                    cell1.getCoordinate().getY() + CentraliserRobot.coordinates[i][1]);
            if (CentraliserRobot.findByCoordinate(c) != null) {
                result.add(CentraliserRobot.findByCoordinate(c));
            }
        }

        return result;
    }

    private AStarGraph initGraph(Cell cell) {
        if ()
    }

}
