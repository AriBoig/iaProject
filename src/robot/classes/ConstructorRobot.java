package robot.classes;

import map.Cell;
import robot.enums.Mode;
import robot.enums.Type;

public class ConstructorRobot extends Robot
{
    private static final int NB_DAY_CONSTRUCTOR_PIPELINE = 2;

    public ConstructorRobot(Cell cell)
    {
        super(cell);
        //action = Mode.NOTHING;
        setType(Type.CONSTRUCTER);
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


