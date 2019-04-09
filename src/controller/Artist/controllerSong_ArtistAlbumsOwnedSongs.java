package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import controller.controller_AddSong;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSearchables_ArtistAllSearchResults;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;

public class controllerSong_ArtistAlbumsOwnedSongs extends PaneController  {

	public controllerSong_ArtistAlbumsOwnedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
		super(dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistAlbumsOwnedSongs(mainPane,this, dashboardController);
	}

	public void uploadSong() {
		PaneController upload = new controller_AddSong(dashboardController.getPaneFoundation(), dashboardController);
		dashboardController.setCurrentPane(upload);
	}
}
