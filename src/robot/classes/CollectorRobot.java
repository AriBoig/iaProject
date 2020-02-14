package robot.classes;

import map.Cell;
import map.TypeCase;
import robot.enums.Mode;
import robot.enums.Type;

public class CollectorRobot extends Robot
{

    private static final int PERCENT_OF_COLLECTING = 10;


    public CollectorRobot(Cell cell)
    {
        super(cell);
        setType(Type.COLLECTER);
    }

    /**
     * @author AC
     * @author Enzo DECHAENE
     */
    @Override
    public void checkCell()
    {
        if (this.action == Mode.EXPLORATION || this.action == Mode.OPERATION) {
            if (getCell().getType() == TypeCase.FOOD) {
                this.action = Mode.WORK; /* Le robot se met au travail */

                // TODO envoyer information au centraliser
            }
        }

        // TODO move le robot si sa case ne lui plait pas
        move();
    }
}
