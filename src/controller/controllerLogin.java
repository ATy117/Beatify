package controller;

import Facade.MasterFacade;
import javafx.stage.Stage;
import object.User;
import view.viewLogin;

public class controllerLogin extends Controller {

    public controllerLogin (Stage primaryStage) {
        facade = MasterFacade.getInstance();
        view = new viewLogin(primaryStage, this);
        facade.generateCacheFolder();
    }

    public User userLogin(String username, String password) {
        return facade.loginUser(username, password);
    }
}
