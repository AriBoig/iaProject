package main;

import container.PrincipalContainerController;
import controller.PrincipalViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {

    private BorderPane principalContainer;
    private Stage principalStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        principalStage = primaryStage;
        principalStage.setTitle("IA");
        principalStage.setResizable(false);
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
            controller.launchGameBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
