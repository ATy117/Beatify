package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;

public class controllerSong_ArtistPlaylistFollowedSongs extends PaneController {

	public controllerSong_ArtistPlaylistFollowedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistPlaylistsFollowedSongs( mainPane,this, dashboardController);
	}

}
