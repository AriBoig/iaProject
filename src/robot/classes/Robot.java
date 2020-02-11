package robot.classes;

import map.Cell;


public class Robot
{
    protected double energy; /* Ajoute mais pas necessaire dans le sujet */
    public int health;
    public Mode action;
    protected Cell cell;
    protected Neighbour neighbour;

    public Robot() {
        this.health = 100;
        this.action = Mode.EXPLORATION;
    }



    /**
     * Fonction qui permet de deplacer le robot sur une Cell adjacente.
     * @author Enzo DECHAENE.
     */
    protected void move()
    {

    }

    /**
     * Need to be @override for all robot
     */
    protected void checkCell()
    {

    }


    /**
     * @return the Cell where is the robot.
     * @author Enzo DECHAENE.
     */
    public Cell getCell() { return cell; }

    /**
     * @author AC
     * @return
     */
    public Neighbour getNeighbour() {
        return neighbour;
    }
}
