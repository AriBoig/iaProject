package robot.algo;

/**
 * Class for the metamorphosis of the robots
 * @author Enzo DECHAENE
 * @date 11/02/2020
 */

import com.fuzzylite.Engine;
import com.fuzzylite.imex.FllImporter;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;
import display.main.MainClass;
import map.Cell;
import map.Coordinate;
import map.Gameboard;
import map.TypeCase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metamorphose
{

    private double routinePercentWater;
    private double routinePercentOre;
    private Engine engine;
    private InputVariable mMetamorphosis;
    private InputVariable drawnedWater;
    private OutputVariable healthRobot;

    /**
     * Load the FLL file
     * @author Enzo DECHAENE
     */
    public void loadFLL()
    {
        try {
            engine = new FllImporter().fromFile(new File("src/robot/algo/metamorphose.fll"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMetamorphosis = engine.getInputVariable("mMetamorphosis");
        drawnedWater = engine.getInputVariable("drawnedwater");
        healthRobot = engine.getOutputVariable("healthRobot");
        Logger.getLogger("javafx").setLevel(Level.OFF);
    }

    /**
     * Set the values of the variables from fll
     * @author Enzo DECHAENE
     */
    //TODO enlever les vals fixes
    public double loadResultFromFLL()
    {
        routinePercentOre = 90;
        routinePercentWater = 90;

        mMetamorphosis.setValue(routinePercentOre);
        drawnedWater.setValue(routinePercentWater);
        engine.process();

        routinePercentWater = 0;
        routinePercentOre = 0;

        return healthRobot.getValue();
    }

    /**
     * Assesseurs
     * @author Enzo DECHAENE
     */
    public double getRoutinePercentWater() {
        return routinePercentWater;
    }

    public void setRoutinePercentWater(double routinePercentWater) {
        this.routinePercentWater = routinePercentWater;
    }

    public double getRoutinePercentOre() {
        return routinePercentOre;
    }

    public void setRoutinePercentOre(double routinePercentOre) {
        this.routinePercentOre = routinePercentOre;
    }

    /**
     * Choose X random cases (X = [21*21]*[percent/100]) to transform them with the metamorphRandomFromCell method
     * @param percent
     * @author Isaë LE MOIGNE
     */
    public void chooseMetamorphosisCell(double percent)
    {
        Gameboard gameboard = MainClass.getGameboard();
        int roundedPercent = (int)percent;
        int nbOfCases = ((gameboard.getSizeX()*gameboard.getSizeY())*(roundedPercent))/100;
        ArrayList<Coordinate> cellList=new ArrayList<Coordinate>();
        for(int x = 0; x < nbOfCases; x++){
            int randX, randY;
            randX = randomGen(0,21);
            randY = randomGen(0,21);
            Coordinate randomCell = new Coordinate(randX, randY);
            while(cellList.contains(randomCell)){
                randX = randomGen(0,21);
                randY = randomGen(0,21);
                randomCell = new Coordinate(randX, randY);
            }
            cellList.add(randomCell);
            metamorphRandomFromCell(gameboard.getGameboard()[randX][randY]);
        }
    }

    /**
     * Get the type of a random cell and transform it
     * @param cell
     * @return cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public Cell metamorphRandomFromCell(Cell cell)
    {
        if (cell.getType().equals(TypeCase.TREE)){
            fromTree(cell);
        }else if (cell.getType().equals(TypeCase.DRY_MEDOW)){
            fromDryMedow(cell);
        }else if (cell.getType().equals(TypeCase.NORMAL_MEDOW)){
            fromNormalMedow(cell);
        }else if (cell.getType().equals(TypeCase.OILY_MEDOW)){
            fromOilyMedow(cell);
        }else if (cell.getType().equals(TypeCase.DESERT)){
            fromDesert(cell);
        }else if (cell.getType().equals(TypeCase.FOOD)){
            fromFood(cell);
        }else if (cell.getType().equals(TypeCase.SCREE)){
            fromScree(cell);
        }else if (cell.getType().equals(TypeCase.ORE)){
            fromOre(cell);
        }else if (cell.getType().equals(TypeCase.IMPASSABLE_AREA)){
            fromImpassable(cell);
        }
        return cell;
    }

    /**
     * Get the percentages of "water" and "ore" to use it with FuzzyLite
     * @author Aristide BOISGONTIER.
     */
    public void routinePercent()
    {
        Gameboard gameboard = MainClass.getGameboard();
        routinePercentWater = 0;
        routinePercentOre = 0;
        int nbWater = 0;
        int nbOre = 0;
        for (int i = 0; i < gameboard.getSizeX(); i++) {
            for (int j = 0; j < gameboard.getSizeY(); j++) {
                if (gameboard.getGameboard()[i][j].getFoodNb() == 0){
                    gameboard.getGameboard()[i][j].setType(TypeCase.DRY_MEDOW);
                }
                if (gameboard.getGameboard()[i][j].getWaterNb() == 0){
                    gameboard.getGameboard()[i][j].setType(TypeCase.SCREE);
                    nbWater++;
                }
                if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.WATER)){
                    nbWater++;
                    if(gameboard.getGameboard()[i][j].isExtraction()) {
                        routinePercentWater++;
                    }
                }
                if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.ORE)){
                    nbOre++;
                    if(gameboard.getGameboard()[i][j].isExtraction()) {
                        routinePercentOre++;
                    }
                }
            }
        }
        routinePercentWater = routinePercentWater/nbWater;
        routinePercentOre = routinePercentOre/nbOre;
    }

    /**
     * Generate a random integer
     * @param high, low
     * @return the random number (>= low, < high)
     * @author Isaë LE MOIGNE.
     */
    public int randomGen(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    /**
     * Metamorphosis of a "TREE" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromTree(Cell cell)
    {
        int rand;
        rand = randomGen(0,10001);
        if (rand >= 0 && rand <= 2000){
            cell.setType(TypeCase.DRY_MEDOW);
        }
        if (rand > 2000 && rand <= 5000){
            cell.setType(TypeCase.NORMAL_MEDOW);
        }
        if (rand > 5000 && rand <= 9000){
            cell.setType(TypeCase.OILY_MEDOW);
        }
        if (rand > 9000 && rand <= 9900){
            cell.setType(TypeCase.DESERT);
        }
        if (rand == 9901){
            cell.setType(TypeCase.IMPASSABLE_AREA);
        }
    }

    /**
     * Metamorphosis of a "DRY_MEDOW" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromDryMedow(Cell cell)
    {
        int rand;
        rand = randomGen(0,10001);
        if (rand >= 0 && rand <= 8000){
            cell.setType(TypeCase.DESERT);
        }
        if (rand > 8000 && rand <= 9900){
            cell.setType(TypeCase.FOOD);
            cell.setFoodNb(100);
        }
        if (rand == 9901){
            cell.setType(TypeCase.IMPASSABLE_AREA);
        }
    }

    /**
     * Metamorphosis of a "NORMAL_MEDOW" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromNormalMedow(Cell cell)
    {
        int rand;
        rand = randomGen(0,10001);
        if (rand >= 0 && rand <= 1000){
            cell.setType(TypeCase.DESERT);
        }
        if (rand > 1000 && rand <= 7000){
            cell.setType(TypeCase.DRY_MEDOW);
        }
        if (rand > 7000 && rand <= 10000){
            cell.setType(TypeCase.FOOD);
            cell.setFoodNb(100);
        }
    }

    /**
     * Metamorphosis of a "OILY_MEDOW" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromOilyMedow(Cell cell){
        int rand;
        rand = randomGen(0,10001);
        if (rand >= 0 && rand <= 500){
            cell.setType(TypeCase.DESERT);
        }
        if (rand > 500 && rand <= 4500){
            cell.setType(TypeCase.NORMAL_MEDOW);
        }
        if (rand > 4500 && rand <= 7500){
            cell.setType(TypeCase.DRY_MEDOW);
        }
        if (rand > 7500 && rand <= 10000){
            cell.setType(TypeCase.FOOD);
            cell.setFoodNb(100);
        }
    }

    /**
     * Metamorphosis of a "DESERT" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromDesert(Cell cell){
        int rand;
        rand = randomGen(0,10001);
        if (rand >= 0 && rand <= 6500){
            cell.setType(TypeCase.DRY_MEDOW);
        }
        if (rand > 6500 && rand <= 6510){
            cell.setType(TypeCase.IMPASSABLE_AREA);
        }
    }

    /**
     * Metamorphosis of a "FOOD" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromFood(Cell cell){
        int rand;
        rand = randomGen(0,10001);
        if (rand >= 0 && rand <= 5000){
            cell.setType(TypeCase.OILY_MEDOW);
            cell.setFoodNb(0);
        }
        if (rand > 5000 && rand <= 8000){
            cell.setType(TypeCase.NORMAL_MEDOW);
            cell.setFoodNb(0);
        }
        if (rand > 8000 && rand <= 9000){
            cell.setType(TypeCase.DRY_MEDOW);
            cell.setFoodNb(0);
        }
        if (rand > 9000 && rand <= 10000){
            cell.setType(TypeCase.TREE);
            cell.setFoodNb(0);
        }
    }

    /**
     * Metamorphosis of a "IMPASSABLE_AREA" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromImpassable(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 1){
            cell.setType(TypeCase.DESERT);
        }
    }

    /**
     * Metamorphosis of a "SCREE" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromScree(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 2){
            cell.setType(TypeCase.ORE);
            cell.setOreNb(100);
        }
    }

    /**
     * Metamorphosis of a "ORE" cell
     * @param cell
     * @author Isaë LE MOIGNE.
     * @author Arstide BOISGONTIER
     */
    public void fromOre(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 5){
            cell.setType(TypeCase.SCREE);
            cell.setOreNb(0);
        }
    }
}

