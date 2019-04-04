package controller;

import javafx.stage.Stage;
import model.*;
import object.User;
import view.View;
import view.viewDashboard;
import view.viewMusicPlayer;

public abstract class controllerDashboard extends Controller{

	protected View currentPane;

	public controllerDashboard (Stage primaryStage, User user) {
		this.primaryStage = primaryStage;
		model = ModelCentral.getInstance();
		model.resetModels();

		model.setProfileModel(new ProfileModel());
		model.setPlayerModel(new SongPlayerModel());
		model.setLibraryModel(new LibraryModel());
		model.setPeopleModel(new OtherPeopleModel());
	}

	public View getCurrentPane() {
		return this.currentPane;
	}
}
