package controller;

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
		model.resetModels();

		model.setProfileModel(new ProfileModel());
		model.setPlayerModel(new SongPlayerModel());
		model.setLibraryModel(new LibraryModel());
		model.setPeopleModel(new OtherPeopleModel());
	}


	public void setCurrentPane(PaneController currentController) {
		this.currentController = currentController;
		model.DetachToAll(currentPane);
		currentPane = currentController.getPaneView();
		model.AttachToAll(currentPane);
	}

	public void setFoundationPane(AnchorPane centerCurrentAnchor) {
		paneFoundation = centerCurrentAnchor;
	}
}
