package map;

/**
 * Classe Metamorphose
 * @author Aristide Boisgontier
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

    float routinePercentWater;
    float routinePercentOre;
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

    public TypeCase MetamorphRandomFromCell(TypeCase typeCase){
        TypeCase toReturn = null;
        if (typeCase.equals(TypeCase.TREE)){
            toReturn = fromTree();
        }else if (typeCase.equals(TypeCase.DRY_MEDOW)){
            toReturn = fromDryMedow();
        }else if (typeCase.equals(TypeCase.NORMAL_MEDOW)){
            toReturn = fromNormalMedow();
        }else if (typeCase.equals(TypeCase.OILY_MEDOW)){
            toReturn = fromOilyMedow();
        }else if (typeCase.equals(TypeCase.DESERT)){
            toReturn = fromDesert();
        }else if (typeCase.equals(TypeCase.FOOD)){
            toReturn = fromInfranchissable();
        }else if (typeCase.equals(TypeCase.SCREE)){
            toReturn = fromScree();
        }else if (typeCase.equals(TypeCase.ORE)){
            toReturn = fromOre();
        }
        if (toReturn == null){
            return typeCase;
        }else{
            return toReturn;
        }
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
                if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.WATER)
                && gameboard.getGameboard()[i][j].isExtraction()){
                    routinePercentWater++;
                }
                if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.ORE)
                && gameboard.getGameboard()[i][j].isExtraction()){
                    routinePercentOre++;
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


    public TypeCase fromTree(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0,101);
        if (rand <= 20){
            toReturn = TypeCase.DRY_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 30){
            toReturn = TypeCase.NORMAL_MEDOW;
        }
        rand = randomGen(0,101);
        if (rand <= 40){
            toReturn = TypeCase.OILY_MEDOW;
        }
        rand = randomGen(0,10);
        if (rand <= 9){
            toReturn = TypeCase.DESERT;
        }
        rand = randomGen(0,10001);
        if (rand <= 1){
            toReturn = TypeCase.IMPASSABLE_AREA;
            }
        return toReturn;
    }

    public TypeCase fromDryMedow(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 80) {
            toReturn = TypeCase.DESERT;
        }
        rand = randomGen(0, 101);
        if (rand <= 19){
            toReturn = TypeCase.FOOD;
        }
        rand = randomGen(0, 1001);
        if (rand <= 1){
            toReturn = TypeCase.IMPASSABLE_AREA;
        }
        return toReturn;
    }

    public TypeCase fromNormalMedow(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 10) {
            toReturn = TypeCase.DESERT;
        }
        rand = randomGen(0, 101);
        if (rand <= 60) {
            toReturn = TypeCase.DRY_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 30) {
            toReturn = TypeCase.FOOD;
        }
        return toReturn;
    }

    public TypeCase fromOilyMedow(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 5) {
            toReturn = TypeCase.DESERT;
        }
        rand = randomGen(0, 101);
        if (rand <= 40) {
            toReturn = TypeCase.NORMAL_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 30) {
            toReturn = TypeCase.DRY_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 25) {
            toReturn = TypeCase.FOOD;
        }
        return toReturn;
    }

    public TypeCase fromDesert(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 65) {
            toReturn = TypeCase.DRY_MEDOW;
        }
        rand = randomGen(0, 1001);
        if (rand <= 1) {
            toReturn = TypeCase.IMPASSABLE_AREA;
        }
        return toReturn;
    }

    public TypeCase fromFood(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 50) {
            toReturn = TypeCase.OILY_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 30) {
            toReturn = TypeCase.NORMAL_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 10) {
            toReturn = TypeCase.DRY_MEDOW;
        }
        rand = randomGen(0, 101);
        if (rand <= 10) {
            toReturn = TypeCase.TREE;
        }
        return toReturn;
    }

    public TypeCase fromInfranchissable(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 1){
            toReturn = TypeCase.DESERT;
        }
        return toReturn;
    }

    public TypeCase fromScree(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 2){
            toReturn = TypeCase.ORE;
        }
        return toReturn;
    }

    public TypeCase fromOre(){
        TypeCase toReturn = null;
        int rand;
        rand = randomGen(0, 101);
        if (rand <= 5){
            toReturn = TypeCase.SCREE;
        }
        return toReturn;
    }
}

