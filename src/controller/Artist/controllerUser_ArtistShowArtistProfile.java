package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistAlbumsFollowedSongs;
import view.Artist.viewUser_ArtistShowArtistProfile;

public class controllerUser_ArtistShowArtistProfile extends PaneController {

    public controllerUser_ArtistShowArtistProfile(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ArtistShowArtistProfile(mainPane,this, dashboardController);
    }
}
