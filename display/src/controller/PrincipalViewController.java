package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.MainClass;

public class PrincipalViewController {

    private MainClass main;

    @FXML
    private GridPane gridpaneGameBoard;
    @FXML
    private ImageView imageViewLegend;

    public void initialize(){
        Image img = new Image("ressources/legende/legende.png");
        imageViewLegend.setImage(img);
    }

    public void setMainClass(MainClass mainApp) {
        this.main = mainApp;
    }

    public void launchGameBoard(){
        Image image = new Image("ressources/terrain/food.png");
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                ImageView imv = new ImageView();
                imv.setImage(image);
                gridpaneGameBoard.add(imv, i, j);
            }
        }
    }

}
