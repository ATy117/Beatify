package controller.Listener;

import controller.controllerDashboard;
import javafx.stage.Stage;
import object.User;
import view.Listener.viewListenerDashboard;

public class controllerListenerDashboard extends controllerDashboard {

	public controllerListenerDashboard (Stage primaryStage, User user) {
		super(primaryStage, user);
		view = new viewListenerDashboard(primaryStage, this);
		model.AttachToAll(view);
	}
}
