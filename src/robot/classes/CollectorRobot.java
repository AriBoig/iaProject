package robot.classes;

import map.TypeCase;

public class CollectorRobot extends Robot
{

    private static final int PERCENT_OF_COLLECTING = 10;


    public CollectorRobot()
    {
        super();
    }

    /**
     * @author Enzo DECHAENE
     */
    @Override
    public void checkCell()
    {
        if (this.action == Mode.EXPLORATION) {
            if (getCell().getType() == TypeCase.FOOD) {
                this.action = Mode.OPERATION; /* Le robot se met en exploitation */

                // TODO envoyer information au centraliser
            }
        }
    }
}
