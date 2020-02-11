package robot.classes;

import map.Cell;
import map.TypeCase;
import robot.algo.LearningEnhancement;
import robot.enums.Direction;
import robot.enums.Mode;

import java.util.Random;


public class Robot
{
    protected double energy; /* Ajoute mais pas necessaire dans le sujet */
    public int health;
    public Mode action;
    protected Cell cell; /* Cellule sur laquelle se trouve le robot */
    protected Neighbour neighbour;
    protected LearningEnhancement learningEnhancement;

    public Robot()
    {
        health              = 100;
        action              = Mode.EXPLORATION;
        learningEnhancement = new LearningEnhancement();
    }

    /**
     * Fonction qui permet de deplacer le robot sur une Cell adjacente.
     * @author Enzo DECHAENE.
     */
    protected void move()
    {
        if (learningEnhancement.getTypeMove() == Mode.EXPLORATION)
        {
            Direction direction = Direction.getRandomDirection();
            Cell nextCell = neighbour.findCellByDirection(direction);

            if (nextCell.getType() != TypeCase.IMPASSABLE_AREA && nextCell.getType() != TypeCase.WATER
                    && !nextCell.isOccupe())
            {
                // TODO faire le mouvement du robot sur la case concerne
                cell = nextCell;
                neighbour.updateNeighbour(cell);
            }
        }
        else {
            // TODO faire en fonction du Q-LEARNING
        }
    }

    /**
     * Need to be @override for all robot
     */
    protected void checkCell()
    {

    }

    /**
     * @return the Cell where is the robot.
     * @author Enzo DECHAENE.
     */
    public Cell getCell() { return cell; }

    /**
     * @author AC
     * @return
     */
    public Neighbour getNeighbour() {
        return neighbour;
    }
}
