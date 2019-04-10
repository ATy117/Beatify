package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistShowArtistAlbumSongs;
import view.Listener.viewSong_ListenerShowArtistAlbumSongs;

public class controllerSong_ListenerShowArtistAlbumSongs extends PaneController {

    public  controllerSong_ListenerShowArtistAlbumSongs (AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerShowArtistAlbumSongs(  mainPane,this, dashboardController);
    }
}
