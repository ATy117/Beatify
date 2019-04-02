package controller;

import javafx.stage.Stage;
import view.viewLogin;

public class controllerLogin extends Controller {

    public controllerLogin (Stage primaryStage) {
        viewLogin view = new viewLogin(primaryStage, this);

    }
}
