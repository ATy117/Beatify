package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;

public class controllerSong_ArtistPlaylistsOwnedSongs extends PaneController {

	public  controllerSong_ArtistPlaylistsOwnedSongs (AnchorPane mainPane, controllerDashboard dashboardController){
		super(dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistPlaylistsOwnedSongs(  mainPane,this, dashboardController);
	}
}
