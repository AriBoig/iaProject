/**
 * @author AB
 */
package map;

import java.io.*;

/**
 * Class of the simulaion map
 * @author Aristide Boisgontier & Isaë Le Moigne
 * @date 06/02/2020
 */

public class Gameboard {

    public static final int ROW    = 21;
    public static final int COLUMN = 21;

    private int sizeX;
    private int sizeY;
    private Cell[][] gameboard;

    /**
     * Class constructor
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public Gameboard() {
        this.sizeX = 21;
        this.sizeY = 21;
        gameboard = new Cell[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Coordinate coordinate = new Coordinate(j, i);
                gameboard[i][j] = new Cell(null,0,false, coordinate,0,0,0);
            }
        }

    }

    public void changeCaseToFood(Coordinate c){
        gameboard[c.getY()][c.getX()].setType(TypeCase.FOOD);
        gameboard[c.getY()][c.getX()].setFoodNb(100);
    }

    /**
     * Set the "water" value of the gameboard's cells
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void setValueOfWaterCells(){
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (gameboard[i][j].getType().equals(TypeCase.WATER)){
                    gameboard[i][j].setWaterNb(200000);
                }
            }
        }
    }

    /**
     * Set the "food" value of the gameboard's cells
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void setValueOfFoodCells(){
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (gameboard[i][j].getType().equals(TypeCase.FOOD)){
                    gameboard[i][j].setFoodNb(100);
                }
            }
        }
    }
    /**
     * Set the "ore" value of the gameboard's cells
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void setValueOfOreCells(){
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (gameboard[i][j].getType().equals(TypeCase.ORE)){
                    gameboard[i][j].setOreNb(100);
                }
            }
        }
    }

    /**
     * Get the X size of the gameboard
     * @return sizeX
     * @author Isaë LE MOIGNE.
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Set the X size of the gameboard
     * @param sizeX
     * @author Isaë LE MOIGNE.
     */
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * Get the Y size of the gameboard
     * @return sizeY
     * @author Isaë LE MOIGNE.
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * Initialiser la taille Y de la carte de la simulation
     * @param sizeY
     * @author Isaë LE MOIGNE.
     */
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    /**
     * Récupérer la carte
     * @author Isaë LE MOIGNE.
     */
    public Cell[][] getGameboard() {
        return gameboard;
    }

    /**
     * Set the gameboard
     * @param gameboard
     * @author Isaë LE MOIGNE.
     */
    public void setGameboard(Cell[][] gameboard) {
        this.gameboard = gameboard;
    }


    /**
     * Set the fields by reading files for ALL positions
     * @author Aristide BOISGONTIER.
     */
    public void initializeFieldGameboard(String filePath, TypeCase typeCase){
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        try
        {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            lecteurAvecBuffer = new BufferedReader(fileReader);
            while ((ligne = lecteurAvecBuffer.readLine()) != null){
                String splitter[] = ligne.split(",");
                gameboard[Integer.parseInt(splitter[0])][Integer.parseInt(splitter[1])].setType(typeCase);
            }
            lecteurAvecBuffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Cell getCenterCell() {
        return gameboard[sizeX/2][sizeY/2];
    }
}

