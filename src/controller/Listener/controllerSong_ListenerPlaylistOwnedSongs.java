package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;
import view.Listener.viewSong_ListenerPlaylistOwnedSongs;

public class controllerSong_ListenerPlaylistOwnedSongs extends PaneController {

    public controllerSong_ListenerPlaylistOwnedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerPlaylistOwnedSongs(  mainPane,this, dashboardController);
    }
}
