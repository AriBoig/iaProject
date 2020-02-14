package map;

/**
 * Classe Metamorphose
 * @author Aristide Boisgontier & Isaë Le Moigne
 * @date 11/02/2020
 */

import com.fuzzylite.Engine;
import com.fuzzylite.imex.FllImporter;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;
import display.main.MainClass;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Metamorphose {

    private float routinePercentWater;
    private float routinePercentOre;
    public static void main(String[] args) {
        Engine engine = null;
        try {
            engine = new FllImporter().fromFile(new File("src/map/metamorphose.fll"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder status = new StringBuilder();
        if (!engine.isReady(status))
            throw new RuntimeException("[engine	error]	engine	is	not	ready:" + status);
        InputVariable oreextraction = engine.getInputVariable("oreextraction");
        InputVariable drawnedWater = engine.getInputVariable("drawnedWater");
        OutputVariable mMetamorphosis = engine.getOutputVariable("mMetamorphosis");
    }

    public Cell MetamorphRandomFromCell(Cell cell){
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
    
    public void routinePercent(){
        Gameboard gameboard = MainClass.getGameboard();
        routinePercentWater = 0;
        routinePercentOre = 0;
        int nbWater = 0;
        int nbOre = 0;
        for (int i = 0; i < gameboard.getTailleX(); i++) {
            for (int j = 0; j < gameboard.getTailleY(); j++) {
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

    public int randomGen(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }


    public void fromTree(Cell cell){
        int rand;
        rand = randomGen(0,101);
        if (rand <= 20){
            cell.setType(TypeCase.DRY_MEDOW);
        }
        rand = randomGen(0, 101);
        if (rand <= 30){
            cell.setType(TypeCase.NORMAL_MEDOW);
        }
        rand = randomGen(0,101);
        if (rand <= 40){
            cell.setType(TypeCase.OILY_MEDOW);
        }
        rand = randomGen(0,10);
        if (rand <= 9){
            cell.setType(TypeCase.DESERT);
        }
        rand = randomGen(0,10001);
        if (rand <= 1){
            cell.setType(TypeCase.IMPASSABLE_AREA);
        }
    }

    public void fromDryMedow(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 80) {
            cell.setType(TypeCase.DESERT);
        }
        rand = randomGen(0, 101);
        if (rand <= 19){
            cell.setType(TypeCase.FOOD);
            cell.setFoodNb(100);
        }
        rand = randomGen(0, 1001);
        if (rand <= 1){
            cell.setType(TypeCase.IMPASSABLE_AREA);
        }
    }

    public void fromNormalMedow(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 10) {
            cell.setType(TypeCase.DESERT);
        }
        rand = randomGen(0, 101);
        if (rand <= 60) {
            cell.setType(TypeCase.DRY_MEDOW);
        }
        rand = randomGen(0, 101);
        if (rand <= 30) {
            cell.setType(TypeCase.FOOD);
            cell.setFoodNb(100);
        }
    }

    public void fromOilyMedow(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 5) {
            cell.setType(TypeCase.DESERT);
        }
        rand = randomGen(0, 101);
        if (rand <= 40) {
            cell.setType(TypeCase.NORMAL_MEDOW);
        }
        rand = randomGen(0, 101);
        if (rand <= 30) {
            cell.setType(TypeCase.DRY_MEDOW);
        }
        rand = randomGen(0, 101);
        if (rand <= 25) {
            cell.setType(TypeCase.FOOD);
            cell.setFoodNb(100);
        }
    }

    public void fromDesert(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 65) {
            cell.setType(TypeCase.DRY_MEDOW);
        }
        rand = randomGen(0, 1001);
        if (rand <= 1) {
            cell.setType(TypeCase.IMPASSABLE_AREA);
        }
    }

    public void fromFood(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 50) {
            cell.setType(TypeCase.OILY_MEDOW);
            cell.setFoodNb(0);
        }
        rand = randomGen(0, 101);
        if (rand <= 30) {
            cell.setType(TypeCase.NORMAL_MEDOW);
            cell.setFoodNb(0);
        }
        rand = randomGen(0, 101);
        if (rand <= 10) {
            cell.setType(TypeCase.DRY_MEDOW);
            cell.setFoodNb(0);
        }
        rand = randomGen(0, 101);
        if (rand <= 10) {
            cell.setType(TypeCase.TREE);
            cell.setFoodNb(0);
        }
    }

    public void fromImpassable(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 1){
            cell.setType(TypeCase.DESERT);
        }
    }

    public void fromScree(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 2){
            cell.setType(TypeCase.ORE);
            cell.setOreNb(100);
        }
    }

    public void fromOre(Cell cell){
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 5){
            cell.setType(TypeCase.SCREE);
            cell.setOreNb(0);
        }
    }
}

