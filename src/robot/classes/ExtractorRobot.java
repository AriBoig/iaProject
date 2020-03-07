package robot.classes;

import map.Cell;
import map.TypeCase;
import robot.enums.Mode;
import robot.enums.Type;

public class ExtractorRobot extends Robot
{
    private static final int PERCENT_OF_DRILLING = 2;

    private int turn;
    private int quantityOfOre;


    public ExtractorRobot(Cell cell)
    {
        super(cell);
        action = Mode.EXPLORATION;
        setType(Type.EXTRACTER);

        turn = 0;
        quantityOfOre = 0;
    }

    /**
     * @author ED
     */
    @Override
    public void checkCell()
    {
        if (action == Mode.EXPLORATION || action == Mode.OPERATION) {
            if (getCell().getType() == TypeCase.ORE) {
                action = Mode.WORK; /* Le robot se met au travail */

                // TODO envoyer information au centraliser
            }
        }
        else if (action == Mode.WORK) {
            if (getCell().getType() == TypeCase.ORE) {
                getCell().setOreNb(getCell().getOreNb() - PERCENT_OF_DRILLING);
                quantityOfOre += PERCENT_OF_DRILLING;
            }
            else {
                action = Mode.DELIVERY; /* Le robot livre les minerai a la base */
            }
        }


    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "ExtractorRobot{" +
                "quantityOfOre=" + quantityOfOre +
                '}';
    }
}
