package controller;

import javafx.stage.Stage;

public class controllerRegister extends Controller{

	public controllerRegister (Stage primaryStage) {
		view = new viewRegister(primaryStage, this);
	}
}
