package robot.classes;

import robot.enums.Mode;

public class ConstructorRobot extends Robot
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
        if (this.action == Mode.EXPLORATION || this.action == Mode.OPERATION) {
            if (neighbour.findWater()) {

                this.action = Mode.WORK; /* Le robot se met au travail */

                // TODO checker les cases voisines pour savoir sil y a de l'eau
            }
        }

        // TODO move le robot si sa case ne lui plait pas
        move();
    }
}


