package App;

import DAO.dbConnection;
import controller.Controller;
import controller.controllerLogin;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Controller login = new controllerLogin(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
