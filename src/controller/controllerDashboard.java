package controller;

import Facade.MasterFacade;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;
import object.User;
import view.View;
import view.viewDashboard;
import view.viewMusicPlayer;

public abstract class controllerDashboard extends Controller{

	protected View currentPane;
	protected PaneController currentController;
	protected AnchorPane paneFoundation;

	public controllerDashboard (Stage primaryStage, User user) {
		this.primaryStage = primaryStage;
		model = ModelCentral.getInstance();
		facade = MasterFacade.getInstance();
		model.resetModels();

		model.setProfileModel(new ProfileModel());
		model.setPlayerModel(new SongPlayerModel());
		model.setLibraryModel(new LibraryModel());
		model.setPeopleModel(new OtherPeopleModel());
		model.setSearchModel(new SearchModel());
		model.setNotificationModel(new NotificationModel());
	}

	public void setCurrentPane(PaneController currentController) {
		this.currentController = currentController;
		model.DetachToAll(currentPane);
		currentPane = currentController.getPaneView();
		model.AttachToAll(currentPane);
		System.out.println("Current Pane: " + currentPane.toString());
	}

	public AnchorPane getPaneFoundation() {
		return paneFoundation;
	}

	public void setPaneFoundation(AnchorPane paneFoundation) {
		this.paneFoundation = paneFoundation;
	}
}
