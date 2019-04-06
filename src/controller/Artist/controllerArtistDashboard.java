package controller.Artist;

import controller.controllerDashboard;
import javafx.stage.Stage;
import object.User;
import view.Artist.viewArtistDashboard;

public class controllerArtistDashboard extends controllerDashboard {

	public controllerArtistDashboard(Stage primaryStage, User user) {
		super(primaryStage, user);
		view = new viewArtistDashboard(primaryStage, this);
		model.AttachToAll(view);
	}
}
