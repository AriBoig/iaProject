package robot.classes;

import display.main.MainClass;
import map.Cell;
import map.TypeCase;
import robot.algo.LearningEnhancement;
import robot.algo.QLearning;
import robot.enums.Direction;
import robot.enums.Mode;
import robot.enums.Type;

import java.util.ArrayList;
import java.util.Random;


public class Robot
{
    protected double energy; /* Ajoute mais pas necessaire dans le sujet */
    public int health;
    public Mode action;
    protected Cell cell; /* Cellule sur laquelle se trouve le robot */
    protected Neighbour neighbour;
    protected LearningEnhancement learningEnhancement;
    protected QLearning qLearning;
    protected Type type;


    public Robot(Cell cell)
    {
        health              = 100;
        action              = Mode.EXPLORATION;
        learningEnhancement = new LearningEnhancement();
        this.cell           = cell;
        neighbour           = new Neighbour(this.cell);
    }

    /**
     * Fonction qui permet de deplacer le robot sur une Cell adjacente.
     * @author Enzo DECHAENE.
     */
    public void move()
    {
        checkCell();

        switch (action) {
            case NOTHING:
            case WORK: break;
            case EXPLORATION:
            case OPERATION: chooseAlgorithm(); break;
            case REPAIR:
            case DELIVERY: goBase(); break;
            default:
        }
    }

    /**
     *
     * @param dir
     * @author Enzo DECHAENE
     */
    public void moveBeginGame(Direction dir)
    {
        Cell nextCell = null;

        nextCell = neighbour.findCellByDirection(dir);

        if (nextCell != null && nextCell.getType() != TypeCase.IMPASSABLE_AREA && nextCell.getType() != TypeCase.WATER
                && MainClass.getGameboard().getGameboard()[nextCell.getCoordinate().getY()][nextCell.getCoordinate().getX()].getCapacity() != 1)
        {
            MainClass.getGameboard().getGameboard()[cell.getCoordinate().getY()][cell.getCoordinate().getX()].setCapacity(0);
            cell = nextCell;
            MainClass.getGameboard().getGameboard()[cell.getCoordinate().getY()][cell.getCoordinate().getX()].setCapacity(1);

            neighbour = new Neighbour(cell);
        }
    }

    /**
     * @author Enzo DECHAENE
     */
    private void chooseAlgorithm()
    {
        if (learningEnhancement.getTypeMove() == Mode.EXPLORATION)
        {
            MainClass.getGameboard().getGameboard()[cell.getCoordinate().getY()][cell.getCoordinate().getX()].setCapacity(0);
            cell = chooseGoodCell();
            MainClass.getGameboard().getGameboard()[cell.getCoordinate().getY()][cell.getCoordinate().getX()].setCapacity(1);
            neighbour = new Neighbour(cell);
        }
        else {
            qLearning.init();
            qLearning.calculateQ();
            // TODO faire en fonction du Q-LEARNING

        }
    }

    /**
     *
     * @return
     * @author Enzo DECHAENE
     */
    private Cell chooseGoodCell()
    {
        Cell nextCell = null;

        do {
            nextCell = neighbour.findCellByDirection(Direction.getRandomDirection());

            if (nextCell == null)
                continue;

            if (nextCell.getType() == TypeCase.IMPASSABLE_AREA || nextCell.getType() == TypeCase.WATER)
                continue;

            int capacity = MainClass.getGameboard().getGameboard()[nextCell.getCoordinate().getY()][nextCell.getCoordinate().getX()].getCapacity();
            if (capacity == 1)
                continue;

            break;

        } while (true);

        return nextCell;
    }

    private void goBase()
    {

    }

    /**
     * Tis method allow to know if one of the cells around the robot
     * have been metamorphosed or not. If one or many of them are,
     * the robot let know the changes.
     * @author AC
     * @param robot
     * @return the cells which have been modified
     */
    protected ArrayList<Cell> metamorphosed (Robot robot){

        ArrayList<Cell> changed = new ArrayList<>();

        if (CentraliserRobot.findByCoordinate(robot.getCell().getCoordinate()) == null
        || CentraliserRobot.findByCoordinate(robot.getCell().getCoordinate())
                .getCoordinate().equals(robot.getCell().getCoordinate()))
            changed.add(robot.getCell());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getEast().getCoordinate()) == null
        || CentraliserRobot.findByCoordinate(robot.getNeighbour().getEast().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getEast().getCoordinate()))
            changed.add(robot.getNeighbour().getEast());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getSouth().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getSouth().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getSouth().getCoordinate()))
            changed.add(robot.getNeighbour().getSouth());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getWest().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getWest().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getWest().getCoordinate()))
            changed.add(robot.getNeighbour().getWest());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getNorth().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getNorth().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getNorth().getCoordinate()))
            changed.add(robot.getNeighbour().getNorth());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getNortheast().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getNortheast().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getNortheast().getCoordinate()))
            changed.add(robot.getNeighbour().getNortheast());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getSoutheast().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getSoutheast().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getSoutheast().getCoordinate()))
            changed.add(robot.getNeighbour().getSoutheast());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getSouthwest().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getSouthwest().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getSouthwest().getCoordinate()))
            changed.add(robot.getNeighbour().getSouthwest());

        if (CentraliserRobot.findByCoordinate(robot.getNeighbour().getNorthwest().getCoordinate()) == null
                || CentraliserRobot.findByCoordinate(robot.getNeighbour().getNorthwest().getCoordinate())
                .getCoordinate().equals(robot.getNeighbour().getNorthwest().getCoordinate()))
            changed.add(robot.getNeighbour().getNorthwest());

        changed.forEach(cell -> {
            CentraliserRobot.removeByCoordinate(cell.getCoordinate());
            CentraliserRobot.mapExplored.add(cell);
        });

        return changed;
    }

    /**
     * Need to be @override for all robot
     */
    public void checkCell()
    {

    }


    public Cell getCell() { return cell; }
    public Neighbour getNeighbour() { return neighbour; }
    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }
    public void setCell(Cell cell) { this.cell = cell; }


    @Override
    public String toString() {
        return "Robot {" +
                " action=" + action +
                ", cell=" + cell +
                ", type=" + type +
                ", neibourgh=" + neighbour +
                '}';
    }
}
