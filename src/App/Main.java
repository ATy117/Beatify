package App;

import controller.controllerLogin;
import controller.dbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        controllerLogin login = new controllerLogin(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
