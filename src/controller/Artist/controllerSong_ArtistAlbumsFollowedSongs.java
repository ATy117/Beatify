package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSearchables_ArtistAllSearchResults;
import view.Artist.viewSong_ArtistAlbumsFollowedSongs;

public class controllerSong_ArtistAlbumsFollowedSongs extends PaneController {

    public controllerSong_ArtistAlbumsFollowedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        //view = new viewSong_ArtistAlbumsFollowedSongs(mainPane,this, dashboardController);
    }
}
