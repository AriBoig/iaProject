package robot.classes;

import map.Cell;
import map.TypeCase;
import robot.enums.Mode;

public class ExtractorRobot extends Robot
{
    private static final int PERCENT_OF_DRILLING = 2;


    public ExtractorRobot(Cell cell)
    {
        super(cell);
    }

    /**
     * @author Enzo DECHAENE
     */
    @Override
    public void checkCell()
    {
        if (this.action == Mode.EXPLORATION || this.action == Mode.OPERATION) {
            if (getCell().getType() == TypeCase.ORE) {
                this.action = Mode.WORK; /* Le robot se met au travail */

                // TODO envoyer information au centraliser
            }
        }

        // TODO move le robot si sa case ne lui plait pas
        move();
    }
}
