package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistAlbumsFollowedSongs;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;

public class controllerSong_ArtistAlbumsOwnedSongs extends PaneController {

    public controllerSong_ArtistAlbumsOwnedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ArtistAlbumsOwnedSongs(mainPane,this, dashboardController);
    }
}
