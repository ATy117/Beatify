package controller;

import Facade.MasterFacade;
import javafx.stage.Stage;
import view.viewLogin;

public class controllerLogin extends Controller {

    public controllerLogin (Stage primaryStage) {
        facade = MasterFacade.getInstance();
        view = new viewLogin(primaryStage, this);
    }

    public boolean userLogin(String username, String password) {
        return true;
    }
}
