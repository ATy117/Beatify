package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistPlaylistsFollowedSongs;
import view.Listener.viewSong_ListenerPlaylistFollowedSongs;

public class controllerSong_ListenerPlaylistFollowedSongs extends PaneController {
    public controllerSong_ListenerPlaylistFollowedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerPlaylistFollowedSongs( mainPane,this, dashboardController);
    }
    public void addSongToQueue(Song song) {
        this.model.getPlayerModel().addSongToQueue(song);
    }

    public void playSong(Song song) {
        this.model.getPlayerModel().playSingleSong(song);
    }

    public boolean likeSong(int song_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.likeSong(user_id, song_id);
    }

    public boolean addSongToPlaylist (int song_id, int playlist_id){
        return facade.addSongToPlaylist(song_id, playlist_id);
    }
}
