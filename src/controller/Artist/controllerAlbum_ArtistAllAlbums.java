package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewAlbum_ArtistAllAlbums;

public class controllerAlbum_ArtistAllAlbums extends PaneController {

    public controllerAlbum_ArtistAllAlbums(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setMyAlbums(facade.getMyAlbums(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getLibraryModel().setFollowedAlbums(facade.getFollowedAlbums(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewAlbum_ArtistAllAlbums(mainPane, this, dashboardController);
    }
}
