package robot.classes;

import map.TypeCase;

public class FarmerRobot extends Robot
{
    private static final int NB_DAY_FAT_MEADOW      = 15;
    private static final int NB_DAY_NORMAL_MEADOW   = 30;
    private static final int NB_DAY_DRY_MEADOW      = 60;
    private static final int NB_WATER_FAT_MEADOW    = 100;
    private static final int NB_WATER_NORMAL_MEADOW = 200;
    private static final int NB_WATER_DRY_MEADOW    = 400;


    public FarmerRobot()
    {
        super();
        action = Mode.NOTHING; /* Il doit attendre qu'il y ai de l'eau afin de farmer */
    }

    /**
     * @author Enzo DECHAENE
     */
    @Override
    public void checkCell()
    {
        if (this.action == Mode.EXPLORATION) {
            if (getCell().getType() == TypeCase.DRY_MEDOW || getCell().getType() == TypeCase.NORMAL_MEDOW ||
                    getCell().getType() == TypeCase.OILY_MEDOW)
            {
                this.action = Mode.OPERATION; /* Le robot se met en exploitation */

                switch (getCell().getType()) {
                    case DRY_MEDOW: break;
                    case NORMAL_MEDOW: break;
                    case OILY_MEDOW: break;
                    default:
                }

                // TODO envoyer information au centraliser
            }
        }
    }
}