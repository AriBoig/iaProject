package robot.classes;


public class Robot
{
    private double energy;
    public int health;
    public Mode action;

    public Robot() {
        this.health = 100;
        this.action = Mode.EXPLORATION;
    }

    /**
     * Fonction qui permet de deplacer le robot sur une case adjacente.
     * @author Enzo DECHAENE.
     */
    protected void move()
    {

    }


}
