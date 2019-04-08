package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistShowArtistPlaylistSongs;
import view.Artist.viewSong_ArtistShowListenerPlaylistSongs;

public class controllerSong_ArtistShowListenerPlaylistSongs extends PaneController {

	public  controllerSong_ArtistShowListenerPlaylistSongs (AnchorPane mainPane, controllerDashboard dashboardController){
		super(dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistShowListenerPlaylistSongs(   mainPane,this, dashboardController);
	}
}
