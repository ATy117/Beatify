package controller.Artist;

import controller.controllerDashboard;
import javafx.stage.Stage;
import object.User;
import view.Artist.viewArtistDashboard;

public class controllerArtistDashboard extends controllerDashboard {

	public controllerArtistDashboard(Stage primaryStage, User user) {
		super(primaryStage, user);
		model.getProfileModel().setUser(user);
		model.getLibraryModel().setMyPlaylists(facade.getMyPlaylists(user.getUser_id()));
		model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
		view = new viewArtistDashboard(primaryStage, this);
		model.AttachToAll(view);

		initThread();
		checkNotifs();
	}
}
