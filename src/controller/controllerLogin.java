package controller;

import javafx.stage.Stage;
import view.viewLogin;

public class controllerLogin extends Controller {

    public controllerLogin (Stage primaryStage) {
        view = new viewLogin(primaryStage, this);
    }
}
