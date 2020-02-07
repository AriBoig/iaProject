
import map.TypeCase;
import robot.classes.*;
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
    private static final int NB_TOTAL_DAY           = 2922;


    private int day;
    private List<Robot> robots;


    public Game() {
        day    = 0;
        robots = new ArrayList<Robot>();
    }

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

        this.robots = robots;
    }


    /**
     * La fonction qui permet de mettre a jour la sante des robots en fonction de la metamorphose du terrain.
     * @author Enzo DECHAENE.
     */
    public void metamorphose()
    {
        for (Robot robot:robots) {

            if ("métamorphose limitée" && robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) robots.remove(robot);
            if ("métamorphose limitée" && robot.getCell().getType() != TypeCase.IMPASSABLE_AREA);
            if ("métamorphose petite" && robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) robots.remove(robot);
            if ("métamorphose petite" && robot.getCell().getType() != TypeCase.IMPASSABLE_AREA);
            if ("métamorphose moyenne" && robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) robots.remove(robot);
            if ("métamorphose moyenne" && robot.getCell().getType() != TypeCase.IMPASSABLE_AREA) robot.health -= 10;
            if ("métamorphose grande" && robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) robots.remove(robot);
            if ("métamorphose grande" && robot.getCell().getType() != TypeCase.IMPASSABLE_AREA) robot.health -= 10;
            if ("métamorphose importante" && robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) robots.remove(robot);
            if ("métamorphose importante" && robot.getCell().getType() != TypeCase.IMPASSABLE_AREA) robots.remove(robot);
        }
    }

    private static Logger logger = Logger.getLogger("logger");

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeRobots();
    }
}





