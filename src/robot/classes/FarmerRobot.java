package robot.classes;

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
}