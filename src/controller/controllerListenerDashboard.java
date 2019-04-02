package controller;

import javafx.stage.Stage;
import view.viewDashboard;
import view.viewListenerDashboard;

public class controllerListenerDashboard extends controllerDashboard{

	public controllerListenerDashboard (Stage primaryStage) {
		viewDashboard view = new viewListenerDashboard(primaryStage, this);
	}
}
