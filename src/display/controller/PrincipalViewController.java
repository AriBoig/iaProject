package display.controller;

import display.main.MainClass;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import map.Gameboard;
import map.TypeCase;


public class PrincipalViewController {

    private MainClass main;
    private Gameboard gameboard;
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

    public void initializeGameboardFromMain(){
        this.gameboard = main.getGameboard();
    }

    public void initialize(){
        Image img = new Image("src/display/ressources/legende/legende.png");
        imageViewLegend.setImage(img);
    }

    public void setMainClass(MainClass mainApp) {
        this.main = mainApp;
    }

    public void initializeImages(){
        imageBase = new Image("src/display/ressources/field/base.png");
        imageDesert = new Image("src/display/ressources/field/desert.png");
        imageDryMedow = new Image("src/display/ressources/field/dryMedow.png");
        imageFood = new Image("src/display/ressources/field/food.png");
        imageImpassableArea = new Image("src/display/ressources/field/impassableArea.png");
        imageNormalMedow = new Image("src/display/ressources/field/normalMedow.png");
        imageOilyMedow = new Image("src/display/ressources/field/oilyMedow.png");
        imageOre = new Image("src/display/ressources/field/ore.png");
        imageScree = new Image("src/display/ressources/field/scree.png");
        imageTree = new Image("src/display/ressources/field/tree.png");
        imageWater = new Image("src/display/ressources/field/water.png");
    }

    public void refreshGameboardMap(){
        for (int i = 0; i < gameboard.getTailleX(); i++) {
            for (int j = 0; j < gameboard.getTailleY(); j++) {
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

    public void refreshGameBoardRobot(){
        for (int i = 0; i < gameboard.getTailleX(); i++) {
            for (int j = 0; j < gameboard.getTailleY(); j++) {
                if (gameboard.getGameboard()[i][j].getCapacite() != 0){

                }
            }
        }
    }

}
