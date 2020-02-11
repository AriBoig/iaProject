/**
 * @author AB
 * @author AC
 */
package map;

/**
 * Classe des cellules du gameboard
 * @author Aristide Boisgontier
 * @date 06/02/2020
 */

public class Cell {
    private TypeCase type;
    private int capacite;
    private boolean metamorphose;
    private Coordinate coordinate;


    public Cell(TypeCase type, int capacite, boolean metamorphose, Coordinate coordinate) {
        this.type = type;
        this.capacite = capacite;
        this.metamorphose = metamorphose;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public TypeCase getType() {
        return type;
    }

    public void setType(TypeCase type) {
        this.type = type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public boolean isMetamorphose() {
        return metamorphose;
    }

    public void setMetamorphose(boolean metamorphose) {
        this.metamorphose = metamorphose;
    }
}
