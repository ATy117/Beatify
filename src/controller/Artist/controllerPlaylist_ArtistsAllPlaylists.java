package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewPlaylist_ArtistAllPlaylists;

public class controllerPlaylist_ArtistsAllPlaylists extends PaneController {

    public controllerPlaylist_ArtistsAllPlaylists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewPlaylist_ArtistAllPlaylists(mainPane, this, dashboardController);
    }
}
