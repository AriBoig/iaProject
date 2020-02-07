package robot.classes;

import map.TypeCase;

public class ConstructorRobot extends WorkerRobot
{
    private static final int NB_DAY_CONSTRUCTOR_PIPELINE = 2;

    public ConstructorRobot()
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
            if (neighbour.findWater()) {

                this.action = Mode.OPERATION; /* Le robot se met en exploitation */

                // TODO checker les cases voisines pour savoir sil y a de l'eau
            }
        }
    }
}


