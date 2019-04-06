package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistAllSongs;

public class controllerSong_ArtistAllSongs extends PaneController {

    public controllerSong_ArtistAllSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ArtistAllSongs(mainPane, this, dashboardController);
    }
}
