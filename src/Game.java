import classes.robot.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game
{
    private static final int NB_ROBOT               = 12;
    private static final int NB_CENTRALISER_ROBOT   = 1;
    private static final int NB_FARMER_ROBOT        = 2;
    private static final int NB_EXTRACTOR_ROBOT     = 3;
    private static final int NB_CONSTRUCTOR_ROBOT   = 3;
    private static final int NB_COLLECTOR_ROBOT     = 3;

    private static Logger logger = Logger.getLogger("logger");



    /**
     * Fonction qui permet d'initialiser les robots.
     * @author Enzo DECHAENE.
     */
    public void initializeRobots()
    {
        List<Robot> robots = new ArrayList<Robot>();

        for (int i = 0; i < NB_CENTRALISER_ROBOT; i++) {
            robots.add(new CentraliserRobot());
        }

        for (int i = 0; i < NB_FARMER_ROBOT; i++) {
            robots.add(new FarmerRobot());
        }

        for (int i = 0; i < NB_EXTRACTOR_ROBOT; i++) {
            robots.add(new ExtractorRobot());
        }

        for (int i = 0; i < NB_CONSTRUCTOR_ROBOT; i++) {
            robots.add(new ConstructorRobot());
        }

        for (int i = 0; i < NB_COLLECTOR_ROBOT; i++) {
            robots.add(new CollectorRobot());
        }

        if (robots.size() != NB_ROBOT) {
            logger.log(Level.SEVERE, "Nombre de robot <"+NB_ROBOT+"> différents du nombre de robot total <"+robots.size()+">");
            System.exit(1);
        }

    }

    public static void main(String[] args) {

    }
}


