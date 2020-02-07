package robot.classes;

import map.TypeCase;

public class ExtractorRobot extends WorkerRobot
{
    private static final int PERCENT_OF_DRILLING = 2;


    public ExtractorRobot()
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
            if (getCell().getType() == TypeCase.ORE) {
                this.action = Mode.OPERATION; /* Le robot se met en exploitation */

                // TODO envoyer information au centraliser
            }
        }
    }
}
