package controller;

import javafx.stage.Stage;
import object.User;
import view.viewDashboard;
import view.viewListenerDashboard;

public class controllerListenerDashboard extends controllerDashboard{

	public controllerListenerDashboard (Stage primaryStage, User user) {
		super(primaryStage, user);
		view = new viewListenerDashboard(primaryStage, this, model);
	}
}
