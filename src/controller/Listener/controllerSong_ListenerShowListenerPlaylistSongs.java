package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistShowListenerPlaylistSongs;
import view.Listener.viewSong_ListenerShowListenerPlaylistSongs;

public class controllerSong_ListenerShowListenerPlaylistSongs extends PaneController {

    public  controllerSong_ListenerShowListenerPlaylistSongs (AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerShowListenerPlaylistSongs(mainPane,this, dashboardController);
    }

    public void addSongToQueue(Song song) {
        this.model.getPlayerModel().addSongToQueue(song);
    }

    public void playSong(Song song) {
        this.model.getPlayerModel().playSingleSong(song);
    }

    public boolean addSongToPlaylist (int song_id, int playlist_id){
        return facade.addSongToPlaylist(song_id, playlist_id);
    }
}
