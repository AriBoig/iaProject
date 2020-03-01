package display.controller;

/**
 * Classe qui affiche le gameboard et sa légende en javafx
 * @author Aristide Boisgontier
 * @date 06/02/2020
 */

import display.main.MainClass;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import map.Gameboard;
import map.Metamorphose;
import map.TypeCase;
import robot.classes.*;
import robot.enums.Type;

import java.util.List;


public class PrincipalViewController {

    private MainClass main;
    private Gameboard gameboard;
    private List<Robot> robots;
    private Metamorphose metamorphose;

    @FXML
    private GridPane gridpaneGameBoard;
    @FXML
    private ImageView imageViewLegend;
    @FXML
    private Button gameButton;

    private Image imageBase;
    private Image imageDesert;
    private Image imageDryMedow;
    private Image imageFood;
    private Image imageImpassableArea;
    private Image imageNormalMedow;
    private Image imageOilyMedow;
    private Image imageOre;
    private Image imageScree;
    private Image imageTree;
    private Image imageWater;

    private Image imageRobotCentraliser;
    private Image imageRobotCollector;
    private Image imageRobotConstructor;
    private Image imageRobotExtrator;
    private Image imageRobotFarmer;

    private Image imagePipeline;
    private Runnable updater;

    /**
     * This function initialize the map of the gameboard
     */
    public void initializeGameboardFromMain(){
        this.gameboard = MainClass.getgb();
    }

    /**
     * This function initialize the robots of the gameboard
     */
    public void initializeRobotsFromMain(){
        this.robots = MainClass.getListRobot();
    }

    /**
     * This function is launched at the start of the application
     */
    public void initialize(){
        Image img = new Image("file:src/display/ressources/legende/legende.png");
        imageViewLegend.setImage(img);
    }

    public void initializeMetamorph(){
        metamorphose = new Metamorphose();
        metamorphose.loadFLL(1000,500, "src/map/fllFiles/metamorphoseStart.fll");
    }

    /**
     * We get the attribute of the main class to access the statics and other else
     * @param mainApp
     */
    public void setMainClass(MainClass mainApp) {
        this.main = mainApp;
    }

    /**
     * @author Aristide Boisgontier
     * @author Isae Lemoigne
     * This function initialize the images intos the variables of the class for a quick launch
     */
    public void initializeImages(){
        imageBase = new Image("file:src/display/ressources/field/base.png");
        imageDesert = new Image("file:src/display/ressources/field/desert.png");
        imageDryMedow = new Image("file:src/display/ressources/field/dryMedow.png");
        imageFood = new Image("file:src/display/ressources/field/food.png");
        imageImpassableArea = new Image("file:src/display/ressources/field/impassableArea.png");
        imageNormalMedow = new Image("file:src/display/ressources/field/normalMedow.png");
        imageOilyMedow = new Image("file:src/display/ressources/field/oilyMedow.png");
        imageOre = new Image("file:src/display/ressources/field/ore.png");
        imageScree = new Image("file:src/display/ressources/field/scree.png");
        imageTree = new Image("file:src/display/ressources/field/tree.png");
        imageWater = new Image("file:src/display/ressources/field/water.png");



        imageRobotCentraliser = new Image("file:src/display/ressources/robots/robotCentraliser.png");
        imageRobotCollector = new Image("file:src/display/ressources/robots/robotCollector.png");
        imageRobotConstructor = new Image("file:src/display/ressources/robots/robotPipeline.png");
        imageRobotExtrator = new Image("file:src/display/ressources/robots/robotExtractor.png");
        imageRobotFarmer = new Image("file:src/display/ressources/robots/robotFarmer.png");
        imagePipeline  = new Image("file:src/display/ressources/robots/pipeline.png");
    }

    /**
     * This function refresh the gameboard and all the cases into it
     */
    public void refreshGameboardMap(){
        for (int i = 0; i < gameboard.getSizeX(); i++) {
            for (int j = 0; j < gameboard.getSizeY(); j++) {
                if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.WATER)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageWater);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.BASE)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageBase);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.DESERT)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageDesert);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.DRY_MEDOW)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageDryMedow);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.NORMAL_MEDOW)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageNormalMedow);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.OILY_MEDOW)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageOilyMedow);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.FOOD)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageFood);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.ORE)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageOre);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.SCREE)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageScree);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.TREE)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageTree);
                    gridpaneGameBoard.add(imv, i, j);
                }else if (gameboard.getGameboard()[i][j].getType().equals(TypeCase.IMPASSABLE_AREA)){
                    ImageView imv = new ImageView();
                    imv.setImage(imageImpassableArea);
                    gridpaneGameBoard.add(imv, i, j);
                }
            }
        }
    }

    /**
     * This function display the robots on the map
     */
    public void refreshGameBoardRobot(){
        //TODO à retirer
        if (robots.size()!= 0){
            for (int i = 0; i < robots.size(); i++) {
                ImageView imv = new ImageView();
                if (robots.get(i).getCell().getCoordinate() != gameboard.getGameboard()[gameboard.getSizeX()/2]
                    [gameboard.getSizeY()/2].getCoordinate()){
                    if (robots.get(i).getType().equals(Type.CENTRALISER)){
                        imv.setImage(imageRobotCentraliser);
                        gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getY(),
                                robots.get(i).getCell().getCoordinate().getX());
                    }else if (robots.get(i).getType().equals(Type.COLLECTER)){
                        imv.setImage(imageRobotCollector);
                        gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getY(),
                                robots.get(i).getCell().getCoordinate().getX());
                    }else if (robots.get(i).getType().equals(Type.EXTRACTER)){
                        imv.setImage(imageRobotExtrator);
                        gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getY(),
                                robots.get(i).getCell().getCoordinate().getX());
                    }else if (robots.get(i).getType().equals(Type.FARMER)){
                        imv.setImage(imageRobotFarmer);
                        gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getY(),
                                robots.get(i).getCell().getCoordinate().getX());
                    }else if (robots.get(i).getType().equals(Type.CONSTRUCTER)){
                        imv.setImage(imageRobotConstructor);
                        gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getY(),
                                robots.get(i).getCell().getCoordinate().getX());
                    }
                }
            }
        }
    }


    public void initializeRunnable(){
        updater = new Runnable() {
            @Override
            public void run() {
                refreshGameboardMap();
                refreshGameBoardRobot();
            }
        };
    }

    public void game(){
        //Platform.runLater(updater);
        Thread t = new Thread(() ->{
            double result;
            Platform.setImplicitExit(false);
            while(MainClass.getGame().getDay() != 10000){
                try {
                    metamorphose.routinePercent();
                    metamorphose.routineDissatisfaction();
                    result = metamorphose.loadResultFromFLL();
                    metamorphose.chooseMetamorphosisCell(result);
                    MainClass.getGame().turn();
                    Platform.runLater(updater);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public PrincipalViewController getTOTO()
    {
        return this;
    }

}
