package Game;

import map.Cell;
import map.TypeCase;
import robot.classes.*;
import robot.enums.Direction;

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
    public static List<Robot> robots;

    private static Logger logger = Logger.getLogger("logger");

    public Game() {
        day    = 0;
        robots = new ArrayList<Robot>();
    }

    /**
     * Fonction qui permet d'initialiser les robots.
     * @author ED.
     */
    public void initializeRobots(Cell cell)
    {
        List<Robot> robots = new ArrayList<Robot>();

        for (int i = 0; i < NB_CENTRALISER_ROBOT; i++) {
            robots.add(new CentraliserRobot(cell));
        }

        for (int i = 0; i < NB_FARMER_ROBOT; i++) {
            robots.add(new FarmerRobot(cell));
        }

        for (int i = 0; i < NB_EXTRACTOR_ROBOT; i++) {
            robots.add(new ExtractorRobot(cell));
        }

        for (int i = 0; i < NB_CONSTRUCTOR_ROBOT; i++) {
            robots.add(new ConstructorRobot(cell));
        }

        for (int i = 0; i < NB_COLLECTOR_ROBOT; i++) {
            robots.add(new CollectorRobot(cell));
        }

        if (robots.size() != NB_ROBOT) {
            logger.log(Level.SEVERE, "Nombre de robot <"+NB_ROBOT+"> différents du nombre de robot total <"+robots.size()+">");
            System.exit(1);
        }

        Game.robots = robots;
    }

    // TODO
    /*public void changeHealthRobot(double percentMetamorphose)
    {
        for (Robot robot : robots) {
            if (robot.getCell().getType() == TypeCase.IMPASSABLE_AREA) {

            }
            else {

            }
        }
    }*/

    public void moveBeginGame()
    {
        robots.get(1).moveBeginGame(Direction.NORTH);
        robots.get(2).moveBeginGame(Direction.SOUTH);
        robots.get(8).moveBeginGame(Direction.EAST);
        robots.get(9).moveBeginGame(Direction.WEST);
        robots.get(10).moveBeginGame(Direction.NORTHEAST);
        robots.get(6).moveBeginGame(Direction.NORTHWEST);
        robots.get(7).moveBeginGame(Direction.SOUTHEAST);
        if (day >= 2) {
            robots.get(3).moveBeginGame(Direction.SOUTH);
            robots.get(4).moveBeginGame(Direction.NORTH);
            robots.get(5).moveBeginGame(Direction.EAST);
            robots.get(11).moveBeginGame(Direction.WEST);
        }

    }

    /**
     * @author ED
     */
    public void turn()
    {
        /*if (day <= 8) {
            moveBeginGame();
        }
        else if (day < NB_TOTAL_DAY) {
            for (Robot robot : robots) {
                robot.move();
            }
        }

        for (Robot robot : robots) {
            System.out.println(robot);
        }

        day++;*/

        if (day == 0) {
            robots.get(3).moveBeginGame(Direction.SOUTH);
            robots.get(3).moveBeginGame(Direction.SOUTH);
            robots.get(3).moveBeginGame(Direction.SOUTH);
            robots.get(3).moveBeginGame(Direction.SOUTH);
            robots.get(3).moveBeginGame(Direction.EAST);
        }
        else {
            robots.get(3).move();
        }

        System.out.println(robots.get(3).toString());

        day++;
    }

    public CentraliserRobot getCentraliser()
    {
        return (CentraliserRobot) Game.robots.get(0);
    }

    public int getDay() {
        return day;
    }
}





