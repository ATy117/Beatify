package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;

public class controllerSong_ArtistPlaylistFollowedSongs extends PaneController {

	public controllerSong_ArtistPlaylistFollowedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistPlaylistsFollowedSongs( mainPane,this, dashboardController);
	}

	public void addSongToQueue(Song song) {
		this.model.getPlayerModel().addSongToQueue(song);
	}

	public void playSong(Song song) {
		this.model.getPlayerModel().playSingleSong(song);
	}

	public boolean addSongToPlaylist (int song_id, int playlist_id){
		return facade.addSongToPlaylist(song_id, playlist_id);
	}
}
