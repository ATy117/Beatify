package controller;

import javafx.stage.Stage;
import object.User;
import view.viewArtistDashboard;
import view.viewDashboard;
import view.viewListenerDashboard;

public class controllerArtistDashboard extends controllerDashboard{

	public controllerArtistDashboard(Stage primaryStage, User user) {
		super(primaryStage, user);
		view = new viewArtistDashboard(primaryStage, this, model);
		model.AttachToAll(view);
	}
}
