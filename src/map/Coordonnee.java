package map;

/**
 * Classe permettant de communiquer la position d'un objet
 * @author Adrien Costes
 * @date 06/02/2020
 */

public class Coordonnee {

    private int x;
    private int y;

    public Coordonnee(){};

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Boolean equals(Coordonnee coordonnee) {
        return coordonnee.getX() == this.x && coordonnee.getY() == this.y;
    }
}
