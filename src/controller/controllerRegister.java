package controller;

import Facade.MasterFacade;
import javafx.stage.Stage;
import view.viewRegister;

import java.io.File;

public class controllerRegister extends Controller{

	public controllerRegister (Stage primaryStage) {
		facade = MasterFacade.getInstance();
		view = new viewRegister(primaryStage, this);
	}

	public boolean register(String username, String password, String firstName, String lastName, boolean isArtist, File profilePic) {
		return facade.register(username, password, firstName, lastName, isArtist, profilePic);
	}


}
