package robot.classes;

import map.Cell;
import map.TypeCase;
import robot.enums.Mode;
import robot.enums.Type;

public class CollectorRobot extends Robot
{

    private static final int PERCENT_OF_COLLECTING = 10;

    private int turn;
    private int quantityOfOFood;


    public CollectorRobot(Cell cell)
    {
        super(cell);
        action = Mode.NOTHING;
        setType(Type.COLLECTER);

        turn = 0;
        quantityOfOFood = 0;
    }

    /**
     * @author ED
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
        else if (action == Mode.WORK) {
            if (getCell().getType() == TypeCase.FOOD) {
                getCell().setFoodNb(getCell().getFoodNb() - PERCENT_OF_COLLECTING);
                quantityOfOFood += PERCENT_OF_COLLECTING;
            }
            else {
                action = Mode.DELIVERY; /* Le robot livre les minerai a la base */
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "CollectorRobot{" +
                "turn=" + turn +
                ", quantityOfOFood=" + quantityOfOFood +
                '}';
    }
}
