package controller;

import javafx.stage.Stage;
import model.Model;
import model.ModelCentral;
import object.User;
import view.View;
import view.viewDashboard;
import view.viewMusicPlayer;

public abstract class controllerDashboard extends Controller{

	public controllerDashboard (Stage primaryStage, User user) {
		this.primaryStage = primaryStage;
		model = ModelCentral.getInstance();
		model.resetModels();
	}
}
