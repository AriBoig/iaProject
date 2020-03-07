package robot.classes;

import map.Cell;
import map.TypeCase;
import robot.enums.Mode;
import robot.enums.Type;

public class ConstructorRobot extends Robot
{
    private static final int NB_DAY_CONSTRUCTOR_PIPELINE = 2;

    private int turn;


    public ConstructorRobot(Cell cell)
    {
        super(cell);
        action = Mode.NOTHING;
        setType(Type.CONSTRUCTER);

        turn = 0;
    }

    /**
     * @author ED
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
        else if (action == Mode.WORK) {
            if (getCell().getType() != TypeCase.BASE) {
                turn++;
            }
            else {
                action = Mode.DELIVERY; /* Le robot livre les minerai a la base */
            }
        }
    }
}


