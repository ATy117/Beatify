package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSearchables_ArtistAllSearchResults;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;

public class controllerSong_ArtistAlbumsOwnedSong extends PaneController  {

	public controllerSong_ArtistAlbumsOwnedSong (AnchorPane mainPane, controllerDashboard dashboardController){
		super(dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistAlbumsOwnedSongs(mainPane,this, dashboardController);
	}
}
