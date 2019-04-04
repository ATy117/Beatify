package controller;

import javafx.stage.Stage;
import model.LibraryModel;
import model.OtherPeopleModel;
import model.ProfileModel;
import model.SongPlayerModel;
import object.User;
import view.viewDashboard;
import view.viewListenerDashboard;

public class controllerListenerDashboard extends controllerDashboard{

	public controllerListenerDashboard (Stage primaryStage, User user) {
		super(primaryStage, user);
		view = new viewListenerDashboard(primaryStage, this, model);

		model.AttachToAll(view);
	}
}
