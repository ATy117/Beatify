package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewArtist_ArtistFollowedArtists;

public class controllerArtist_ArtistFollowedArtists extends PaneController {

    public controllerArtist_ArtistFollowedArtists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewArtist_ArtistFollowedArtists(mainPane, this, dashboardController);
    }
}
