package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistShowListenerPlaylistSongs;
import view.Artist.viewUser_ArtistShowArtistProfile;

public class controllerUser_ArtistShowArtistsProfile extends PaneController {

	public  controllerUser_ArtistShowArtistsProfile (AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewUser_ArtistShowArtistProfile(   mainPane,this, dashboardController);
	}

	public boolean followAlbum(int album_id){
		int user_id = model.getProfileModel().getUser().getUser_id();
		return facade.followAlbum(user_id, album_id);
	}

	public boolean followPlaylist(int playlist_id){
		int user_id = model.getProfileModel().getUser().getUser_id();
		return facade.followPlaylist(user_id, playlist_id);
	}
}
