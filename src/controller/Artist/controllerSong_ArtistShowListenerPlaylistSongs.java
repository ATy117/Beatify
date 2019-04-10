package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistShowArtistPlaylistSongs;
import view.Artist.viewSong_ArtistShowListenerPlaylistSongs;

public class controllerSong_ArtistShowListenerPlaylistSongs extends PaneController {

	public  controllerSong_ArtistShowListenerPlaylistSongs (AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistShowListenerPlaylistSongs(   mainPane,this, dashboardController);
	}

	public void addSongToQueue(Song song) {
		this.model.getPlayerModel().addSongToQueue(song);
	}

	public void playSong(Song song) {
		this.model.getPlayerModel().playSingleSong(song);
	}
}
