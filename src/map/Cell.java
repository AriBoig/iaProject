/**
 * @author AB
 * @author AC
 */
package map;

/**
 * Classe des cellules du gameboard
 * @author Aristide Boisgontier & Isaë Le Moigne
 * @date 06/02/2020
 */

public class Cell {
    private TypeCase type;
    private int capacite;
    private boolean extraction;
    private Coordinate coordinate;
    private int waterNb;
    private int oreNb;
    private int foodNb;

    public Cell(TypeCase type, int capacite, boolean metamorphose, Coordinate coordinate, int waterNb, int oreNb, int foodNb) {
        this.type = type;
        this.capacite = capacite;
        this.extraction = metamorphose;
        this.coordinate = coordinate;
        this.waterNb = waterNb;
        this.oreNb = oreNb;
        this.foodNb = foodNb;
    }

    public int getWaterNb() {
        return waterNb;
    }

    public void setWaterNb(int waterNb) {
        this.extraction = true;
        this.waterNb = waterNb;
    }

    public int getOreNb() {
        return oreNb;
    }

    public void setOreNb(int oreNb) {
        this.extraction = true;
        this.oreNb = oreNb;
    }

    public int getFoodNb() {
        return foodNb;
    }

    public void setFoodNb(int foodNb) {
        this.foodNb = foodNb;
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

    public boolean isExtraction() {
        return extraction;
    }

    public void setExtraction(boolean extraction) {
        this.extraction = extraction;
    }

}
