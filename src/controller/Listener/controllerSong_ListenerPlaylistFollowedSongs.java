package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;
import view.Listener.viewSong_ListenerPlaylistFollowedSongs;

public class controllerSong_ListenerPlaylistFollowedSongs extends PaneController {
    public controllerSong_ListenerPlaylistFollowedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerPlaylistFollowedSongs( mainPane,this, dashboardController);
    }
}
