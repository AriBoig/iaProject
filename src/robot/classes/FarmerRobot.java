package robot.classes;

import Game.Game;
import display.main.MainClass;
import map.Cell;
import map.TypeCase;
import robot.enums.Mode;
import robot.enums.Type;

public class FarmerRobot extends Robot
{
    private static final int NB_DAY_FAT_MEADOW      = 15;
    private static final int NB_DAY_NORMAL_MEADOW   = 30;
    private static final int NB_DAY_DRY_MEADOW      = 60;
    private static final int NB_WATER_FAT_MEADOW    = 100;
    private static final int NB_WATER_NORMAL_MEADOW = 200;
    private static final int NB_WATER_DRY_MEADOW    = 400;

    private int turn;


    public FarmerRobot(Cell cell)
    {
        super(cell);
        action = Mode.NOTHING; /* Il doit attendre qu'il y ai de l'eau afin de farmer */
        setType(Type.FARMER);

        turn = 0;
    }

    /**
     * @author ED
     */
    @Override
    public void checkCell()
    {
        if (this.action == Mode.EXPLORATION || this.action == Mode.OPERATION) {
            if ((getCell().getType() == TypeCase.DRY_MEADOW || getCell().getType() == TypeCase.NORMAL_MEADOW ||
                    getCell().getType() == TypeCase.OILY_MEADOW) && MainClass.getGame().getCentraliser().getWater() > 0)
            {
                this.action = Mode.WORK; /* Le robot se met au travail */

                switch (getCell().getType()) {
                    case OILY_MEADOW:
                        MainClass.getGame().getCentraliser().setConsumeWater(MainClass.getGame().getCentraliser().getConsumeWater() + NB_WATER_FAT_MEADOW);
                        break;
                    case NORMAL_MEADOW:
                        MainClass.getGame().getCentraliser().setConsumeWater(MainClass.getGame().getCentraliser().getConsumeWater() + NB_WATER_NORMAL_MEADOW);
                        break;
                    case DRY_MEADOW:
                        MainClass.getGame().getCentraliser().setConsumeWater(MainClass.getGame().getCentraliser().getConsumeWater() + NB_WATER_DRY_MEADOW);
                        break;
                }

                // TODO envoyer information au centraliser
            }
        }
        else if (action == Mode.WORK) {

            // TODO enlever leau de la base
            if (getCell().getType() == TypeCase.OILY_MEADOW && turn < NB_DAY_FAT_MEADOW) {
                turn++;
            }
            else if (getCell().getType() == TypeCase.NORMAL_MEADOW && turn < NB_DAY_NORMAL_MEADOW) {
                turn++;
            }
            else if (getCell().getType() == TypeCase.DRY_MEADOW && turn < NB_DAY_DRY_MEADOW) {
                turn++;
            }
            else {
                action = Mode.EXPLORATION;
            }

        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "FarmerRobot{" +
                "turn=" + turn +
                '}';
    }
}