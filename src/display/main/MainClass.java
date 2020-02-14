package display.main;

/**
 * Classe principale de lancement de la simulation. Les ressources et images ont été éditées à la main
 * @author Aristide Boisgontier & Isaë Le Moigne
 * @date 06/02/2020
 */

import Game.Game;
import display.container.PrincipalContainerController;
import display.controller.PrincipalViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import map.Gameboard;
import robot.classes.Robot;
import java.io.IOException;
import java.util.List;

//TODO Modifier TypeCase
public class MainClass extends Application {

    private BorderPane principalContainer;
    private Stage principalStage;
    private static Gameboard gameboard;
    private static List<Robot> listRobot;
    private static Game game;

    public static Gameboard getGameboard() {
        return gameboard;
    }

    public static List<Robot> getListRobot() {
        return listRobot;
    }

    /**
     * This function is launching and intializing the gameboard
     */
    public void iniGameboard(){
        gameboard = new Gameboard();
        gameboard.initializeWaterGameBoard();
        gameboard.initializeBaseGameBoard();
        gameboard.initializeOreGameBoard();
        gameboard.initializeFoodGameBoard();
        gameboard.initializeTreeGameBoard();
        gameboard.initializeDryMedow();
        gameboard.initializeNormalMedow();
        gameboard.initializeOilyMedow();
        gameboard.initializeDesertGameBoard();
        gameboard.initializeScreeGameBoard();
        gameboard.setValueOfWaterCells();
        gameboard.setValueOfFoodCells();
        gameboard.setValueOfOreCells();
    }


    /**
     * This function is intializing the base game
     */
    public void iniGame(){
        game = new Game();
        game.initializeRobots();
        listRobot = game.getRobots();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        principalStage = primaryStage;
        principalStage.setTitle("IA");
        principalStage.setResizable(false);
        iniGameboard();
        iniGame();
        initialiazePrincipalContainer();
        initializePrincipalView();

    }

    public void initialiazePrincipalContainer(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainClass.class.getResource("../container/PrincipalContainer.fxml"));
        try {
            principalContainer = (BorderPane) loader.load();
            Scene scene = new Scene(principalContainer);
            principalStage.setScene(scene);
            PrincipalContainerController controller = loader.getController();
            controller.setMainClass(this);
            principalStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializePrincipalView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainClass.class.getResource("../view/PrincipalView.fxml"));
        try {
            AnchorPane view = (AnchorPane) loader.load();
            principalContainer.setCenter(view);
            PrincipalViewController controller = loader.getController();
            controller.setMainClass(this);
            controller.initializeImages();
            controller.initializeGameboardFromMain();
            controller.initializeRobotsFromMain();
            controller.refreshGameboardMap();
            controller.refreshGameBoardRobot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
