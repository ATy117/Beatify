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

	public void goToAlbumList(int album_id){
		model.getPeopleModel().setSelectedAlbum(facade.getAlbum(album_id));
		model.getPeopleModel().setSongs(facade.getAlbumSongs(album_id));
		controllerSong_ArtistShowArtistAlbumSongs c = new controllerSong_ArtistShowArtistAlbumSongs(mainPane, dashboardController);
		dashboardController.setCurrentPane(c);
	}

	public void goToPlaylistList(int playlist_id){
		model.getPeopleModel().setSelectedPlaylist(facade.getPlaylist(playlist_id));
		model.getPeopleModel().setSongs(facade.getPlaylistSongs(playlist_id));
		controllerSong_ArtistShowArtistPlaylistSongs c = new controllerSong_ArtistShowArtistPlaylistSongs(mainPane, dashboardController);
		dashboardController.setCurrentPane(c);
	}

}
