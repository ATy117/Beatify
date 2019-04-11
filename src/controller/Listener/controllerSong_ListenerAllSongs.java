package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Listener.viewSong_ListenerAllSongs;

public class controllerSong_ListenerAllSongs extends PaneController {
    public controllerSong_ListenerAllSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setAllSongs(facade.getLikedSongs(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewSong_ListenerAllSongs(mainPane,this, dashboardController);
    }

    public boolean addSongToPlaylist (int song_id, int playlist_id){
        return facade.addSongToPlaylist(song_id, playlist_id);
    }

    public void unlikeSong (int song_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.unlikeSong(user_id, song_id);
        model.getLibraryModel().setAllSongs(facade.getLikedSongs(user_id));
    }

    public void addSongToQueue(Song song) {
        this.model.getPlayerModel().addSongToQueue(song);
    }

    public void playSong(Song song) {
        this.model.getPlayerModel().playSingleSong(song);
    }
}
