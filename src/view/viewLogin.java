package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class viewLogin extends View {

    public viewLogin (Stage primaryStage, Controller login) {

        this.primaryStage = primaryStage;
        this.controller = controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateLogin.fxml"));
        loader.setController(this);

        sm = new StageManager(primaryStage);
        sm.loadScene(loader);
        sm.setWindowName("Beatify");

    }


    @Override
    public void Update() {

    }

    public void changePane(ActionEvent actionEvent) {
    }
}
