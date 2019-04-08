package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistAlbumsFollowedSongs;
import view.Artist.viewUser_ArtistShowListenerProfile;

public class controllerUser_ArtistShowListenerProfile extends PaneController {

    public controllerUser_ArtistShowListenerProfile(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ArtistShowListenerProfile(mainPane,this, dashboardController);
    }
}
