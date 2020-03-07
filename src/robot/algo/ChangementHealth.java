package robot.algo;

/**
 * Class for the metamorphosis of the robots
 * @author ED
 * @date 11/02/2020
 */

import com.fuzzylite.Engine;
import com.fuzzylite.imex.FllImporter;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;
import display.main.MainClass;
import map.Cell;
import map.Coordinate;
import map.Gameboard;
import map.TypeCase;
import robot.classes.Robot;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangementHealth
{
    private double routinePercentMetamorphose;
    private Engine engine;
    private InputVariable mMetamorphosis;
    private OutputVariable healthRobot;

    /**
     * Load the FLL file
     * @author ED
     */
    public void loadFLL()
    {
        try {
            engine = new FllImporter().fromFile(new File("src/robot/algo/fllFiles/health.fll"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMetamorphosis = engine.getInputVariable("mMetamorphosis");
        healthRobot = engine.getOutputVariable("healthRobot");
        Logger.getLogger("javafx").setLevel(Level.OFF);
    }

    /**
     * Set the values of the variables from fll
     * @author ED
     */
    //TODO enlever les vals fixes
    public double loadResultFromFLL()
    {
        mMetamorphosis.setValue(routinePercentMetamorphose);

        engine.process();

        routinePercentMetamorphose = 0;

        return healthRobot.getValue();
    }

    /**
     * Assesseurs
     * @author ED
     */
    public double getRoutinePercentMetamorphose() {
        return routinePercentMetamorphose;
    }

    public void setRoutinePercentMetamorphose(double routinePercentMetamorphose) {
        this.routinePercentMetamorphose = routinePercentMetamorphose;
    }

    public void changeHealthRobots(double percentMetamorphose)
    {
        routinePercentMetamorphose = percentMetamorphose;
        double healthRobot = loadResultFromFLL();

        for (Robot robot : MainClass.getListRobot())
        {
            if (robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) {

            }
            else {

            }
        }
    }

}

