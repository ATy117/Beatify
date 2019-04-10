package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewUser_ArtistShowArtistProfile;
import view.Artist.viewUser_ArtistShowListenerProfile;

public class controllerUser_ArtistShowListenerProfile extends PaneController {

	public  controllerUser_ArtistShowListenerProfile (AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewUser_ArtistShowListenerProfile(   mainPane,this, dashboardController);
	}


	public boolean followPlaylist(int playlist_id){
		int user_id = model.getProfileModel().getUser().getUser_id();
		return facade.followPlaylist(user_id, playlist_id);
	}

	public void goToPlaylistList(int playlist_id) {
		model.getPeopleModel().setSelectedPlaylist(facade.getPlaylist(playlist_id));
		model.getPeopleModel().setSongs(facade.getPlaylistSongs(playlist_id));
		controllerSong_ArtistShowListenerPlaylistSongs c = new controllerSong_ArtistShowListenerPlaylistSongs(mainPane, dashboardController);
		dashboardController.setCurrentPane(c);
	}
}
