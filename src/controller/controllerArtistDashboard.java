package controller;

import javafx.stage.Stage;
import view.viewArtistDashboard;
import view.viewDashboard;
import view.viewListenerDashboard;

public class controllerArtistDashboard extends controllerDashboard{

	public controllerArtistDashboard(Stage primaryStage) {
		super(primaryStage);
		view = new viewArtistDashboard(primaryStage, this, model);
	}
}
