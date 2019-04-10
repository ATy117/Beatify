package controller.Listener;

import controller.Artist.controllerSong_ArtistShowListenerPlaylistSongs;
import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewUser_ArtistShowListenerProfile;
import view.Listener.viewUser_ListenerShowListenerProfile;

public class controllerUser_ListenerShowListenerProfile extends PaneController {

    public  controllerUser_ListenerShowListenerProfile (AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ListenerShowListenerProfile(   mainPane,this, dashboardController);
    }

    public boolean followPlaylist(int playlist_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.followPlaylist(user_id, playlist_id);
    }

    public void goToPlaylistList(int playlist_id) {
        model.getPeopleModel().setSelectedPlaylist(facade.getPlaylist(playlist_id));
        model.getPeopleModel().setSongs(facade.getPlaylistSongs(playlist_id));
        controllerSong_ArtistShowListenerPlaylistSongs c = new controllerSong_ArtistShowListenerPlaylistSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }
}
