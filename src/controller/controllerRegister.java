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

	public boolean registerListener(String username, String password, String firstName, String lastName, File profilePic) {
		if (facade.registerListener(username, password, firstName, lastName, profilePic)) {
			return true;
		}
		return false;
	}

	public boolean registerArtist(String username, String password, String firstName, String lastName, File profilePic) {
		if (facade.registerArtist(username, password, firstName, lastName, profilePic)) {
			return true;
		}
		return false;
	}
}
