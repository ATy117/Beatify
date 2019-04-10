package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;

public class controllerSong_ArtistPlaylistOwnedSongs extends PaneController {

	public controllerSong_ArtistPlaylistOwnedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistPlaylistsOwnedSongs(  mainPane,this, dashboardController);
	}

	public void addSongToQueue(Song song) {
		this.model.getPlayerModel().addSongToQueue(song);
	}

	public void deleteSongFromPlaylist(int song_id){
		int playlist_id = model.getLibraryModel().getSelectedPlaylist().getPlaylist_id();
		facade.deleteSongFromPlaylist(song_id, playlist_id);
		model.getLibraryModel().setSongContents(facade.getPlaylistSongs(playlist_id));
	}

	public void playSong(Song song) {
		this.model.getPlayerModel().playSingleSong(song);
	}
}
