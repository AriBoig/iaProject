package display.controller;

/**
 * Classe qui affiche le gameboard et sa légende en javafx
 * @author Aristide Boisgontier
 * @date 06/02/2020
 */

import display.main.MainClass;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import map.Gameboard;
import map.TypeCase;
import robot.classes.*;

import java.util.List;


public class PrincipalViewController {

    private MainClass main;
    private Gameboard gameboard;
    private List<Robot> robots;

    @FXML
    private GridPane gridpaneGameBoard;
    @FXML
    private ImageView imageViewLegend;

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

    /**
     * This function initialize the map of the gameboard
     */
    public void initializeGameboardFromMain(){
        this.gameboard = MainClass.getGameboard();
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
        for (int i = 0; i < robots.size(); i++) {
            ImageView imv = new ImageView();
            if (robots.get(i) instanceof CentraliserRobot){
                imv.setImage(imageRobotCentraliser);
                gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getX(),
                        robots.get(i).getCell().getCoordinate().getY());
            }else if (robots.get(i) instanceof CollectorRobot){
                imv.setImage(imageRobotCollector);
                gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getX(),
                        robots.get(i).getCell().getCoordinate().getY());
            }else if (robots.get(i) instanceof ExtractorRobot){
                imv.setImage(imageRobotExtrator);
                gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getX(),
                        robots.get(i).getCell().getCoordinate().getY());
            }else if (robots.get(i) instanceof FarmerRobot){
                imv.setImage(imageRobotFarmer);
                gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getX(),
                        robots.get(i).getCell().getCoordinate().getY());
            }else if (robots.get(i) instanceof WorkerRobot){
                imv.setImage(imageRobotConstructor);
                gridpaneGameBoard.add(imv,robots.get(i).getCell().getCoordinate().getX(),
                        robots.get(i).getCell().getCoordinate().getY());
            }
        }
    }

}
