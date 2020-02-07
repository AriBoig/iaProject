package robot.classes;

import map.Coordonnee;
import map.TypeCase;

import java.util.ArrayList;

/**
 * @author Enzo Dechaene
 * @author Adrien Costes
 * @date 06/02/2020
 */

public class CentraliserRobot extends Robot
{
    private double mineral;
    private double food;
    private double water;
    private double consumeWater;

    private ArrayList<Coordonnee> mineralPosition;


    public CentraliserRobot()
    {
        super();
    }


    public void collectInfo(TypeCase typeCase, Coordonnee coordonnee) {
        //TODO
    }

    public double getMineral() {
        return mineral;
    }

    public double getFood() {
        return food;
    }

    public double getWater() {
        return water;
    }

    public double getConsumeWater() {
        return consumeWater;
    }
}
