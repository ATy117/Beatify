package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistShowArtistPlaylistSongs;
import view.Listener.viewSong_ListenerShowArtistPlaylistSongs;

public class controllerSong_ListenerShowArtistPlaylistSongs extends PaneController {

    public controllerSong_ListenerShowArtistPlaylistSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerShowArtistPlaylistSongs(   mainPane,this, dashboardController);
    }
}
