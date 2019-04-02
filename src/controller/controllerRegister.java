package controller;

import javafx.stage.Stage;
import view.viewLogin;
import view.viewRegister;

public class controllerRegister extends Controller{

	public controllerRegister (Stage primaryStage) {
		viewRegister view = new viewRegister(primaryStage, this);
	}
}
