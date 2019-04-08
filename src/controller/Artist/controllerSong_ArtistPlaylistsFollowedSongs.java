package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;

public class controllerSong_ArtistPlaylistsFollowedSongs extends PaneController {

	public  controllerSong_ArtistPlaylistsFollowedSongs (AnchorPane mainPane, controllerDashboard dashboardController){
		super(dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistPlaylistsFollowedSongs( mainPane,this, dashboardController);
	}

}
