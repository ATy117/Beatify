package controller;

import javafx.stage.Stage;
import view.viewLogin;

public class controllerLogin extends Controller {

    public controllerLogin (Stage primaryStage) {
        view = new viewLogin(primaryStage, this);
    }

    public boolean userLogin(String username, String password) {

        return true;
    }
}
