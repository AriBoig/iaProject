package map;

/**
 * Classe permettant de communiquer la position d'un objet
 * @author Adrien Costes
 * @date 06/02/2020
 */

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(){};

    public Coordinate(int x, int y) {
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

    public Boolean equals(Coordinate coordinate) {
        return coordinate.getX() == this.x && coordinate.getY() == this.y;
    }
}