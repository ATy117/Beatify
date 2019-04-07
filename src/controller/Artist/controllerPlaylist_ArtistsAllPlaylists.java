package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewPlaylist_ArtistAllPlaylists;

public class controllerPlaylist_ArtistsAllPlaylists extends PaneController {

    public controllerPlaylist_ArtistsAllPlaylists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setMyPlaylists(facade.getMyPlaylists(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getLibraryModel().setFollowedPlaylists(facade.getFollowedPlaylists(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewPlaylist_ArtistAllPlaylists(mainPane, this, dashboardController);
    }
}
