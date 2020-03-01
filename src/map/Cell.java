/**
 * @author AB
 * @author AC
 */
package map;

/**
 * Class of gameboard's cells
 * @author Aristide Boisgontier & Isaë Le Moigne
 * @date 06/02/2020
 */

public class Cell {
    private TypeCase type;
    private int capacity;
    private boolean extraction;
    private Coordinate coordinate;
    private int waterNb;
    private int oreNb;
    private int foodNb;

    /**
     * Class constructor
     * @author Isaë LE MOIGNE.
     */
    public Cell(TypeCase type, int capacity, boolean metamorphose, Coordinate coordinate, int waterNb, int oreNb, int foodNb) {
        this.type = type;
        this.capacity = capacity;
        this.extraction = metamorphose;
        this.coordinate = coordinate;
        this.waterNb = waterNb;
        this.oreNb = oreNb;
        this.foodNb = foodNb;
    }

    /**
     * Get the "water" value
     * @return waterNb
     * @author Isaë LE MOIGNE.
     */
    public int getWaterNb() {
        return waterNb;
    }

    /**
     * Set the "water" value
     * @param waterNb
     * @author Isaë LE MOIGNE.
     */
    public void setWaterNb(int waterNb) {
        this.extraction = true;
        this.waterNb = waterNb;
    }

    /**
     * Get the "ore" value
     * @return oreNb
     * @author Isaë LE MOIGNE.
     */
    public int getOreNb() {
        return oreNb;
    }

    /**
     * Set the "ore" value
     * @param oreNb
     * @author Isaë LE MOIGNE.
     */
    public void setOreNb(int oreNb) {
        this.extraction = true;
        this.oreNb = oreNb;
    }

    /**
     * Get the "food" value
     * @return foodNb
     * @author Isaë LE MOIGNE.
     */
    public int getFoodNb() {
        return foodNb;
    }

    /**
     * Set the "food" value
     * @param foodNb
     * @author Isaë LE MOIGNE.
     */
    public void setFoodNb(int foodNb) {
        this.foodNb = foodNb;
    }

    /**
     * Get the coordinates
     * @return coordinate
     * @author Isaë LE MOIGNE.
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Set the coordinates
     * @param coordinate
     * @author Isaë LE MOIGNE.
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Get the type
     * @return type
     * @author Isaë LE MOIGNE.
     */
    public TypeCase getType() {
        return type;
    }

    /**
     * Set the type
     * @param type
     * @author Isaë LE MOIGNE.
     */
    public void setType(TypeCase type) {
        this.type = type;
    }

    /**
     * Get the capacity
     * @return capacity
     * @author Isaë LE MOIGNE.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set the capacity
     * @param capacity
     * @author Isaë LE MOIGNE.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get the extraction value
     * @return extraction
     * @author Isaë LE MOIGNE.
     */
    public boolean isExtraction() {
        return extraction;
    }

    /**
     * Set the extraction value
     * @param extraction
     * @author Isaë LE MOIGNE.
     */
    public void setExtraction(boolean extraction) {
        this.extraction = extraction;
    }


    public boolean isTop()
    {
        return getCoordinate().getX() == 0;
    }

    public boolean isBottom()
    {
        return getCoordinate().getX() == Gameboard.COLUMN-1;
    }

    public boolean isLeft()
    {
        return getCoordinate().getY() == 0;
    }

    public boolean isRight()
    {
        return getCoordinate().getY() == Gameboard.ROW-1;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "type=" + type +
                ", coordinate=" + coordinate +
                '}';
    }
}
