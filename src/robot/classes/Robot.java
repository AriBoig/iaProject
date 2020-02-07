package robot.classes;

import map.Case;


public class Robot
{
    protected double energy; /* Ajoute mais pas necessaire dans le sujet */
    public int health;
    public Mode action;
    protected Case cell;
    protected Neighbour neighbour;

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
    public Case getCell() { return cell; }

}
