package controller.Listener;

import controller.Controller;
import controller.PaneController;
import controller.controllerDashboard;
import controller.controllerLogin;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import object.User;
import view.Listener.viewUser_ListenerMyProfile;

public class controllerUser_ListenerMyProfile extends PaneController {

    public controllerUser_ListenerMyProfile(AnchorPane mainPane, controllerDashboard dashboardController, Stage primaryStage){
	    super(mainPane, dashboardController);
        this.primaryStage = primaryStage;
        this.model = dashboardController.getModel();
        view = new viewUser_ListenerMyProfile(mainPane, this, dashboardController);
    }

	public void logout() {
    	model.clearViews();
    	dashboardController.setLoggedIn(false);
		Controller login = new controllerLogin(primaryStage);
	}

	public void editUser(User user){
		facade.updateUser(user);
		model.getProfileModel().setUser(facade.loginUser(user.getUsername(), user.getPassword()));
	}
}
