package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistShowListenerPlaylistSongs;
import view.Artist.viewUser_ArtistShowArtistProfile;

public class controllerUser_ArtistShowArtistsProfile extends PaneController {

	public  controllerUser_ArtistShowArtistsProfile (AnchorPane mainPane, controllerDashboard dashboardController){
		super(dashboardController);
		this.model = dashboardController.getModel();
		view = new viewUser_ArtistShowArtistProfile(   mainPane,this, dashboardController);
	}
}
