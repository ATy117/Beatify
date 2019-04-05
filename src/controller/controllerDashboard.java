package controller;

import javafx.stage.Stage;
import model.ModelCentral;
import object.User;

public abstract class controllerDashboard extends Controller{

	public controllerDashboard (Stage primaryStage, User user) {
		this.primaryStage = primaryStage;
		model = ModelCentral.getInstance();
		model.resetModels();
	}
}
