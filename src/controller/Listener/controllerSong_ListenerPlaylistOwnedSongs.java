package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;
import view.Listener.viewSong_ListenerPlaylistOwnedSongs;

public class controllerSong_ListenerPlaylistOwnedSongs extends PaneController {

    public controllerSong_ListenerPlaylistOwnedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerPlaylistOwnedSongs(  mainPane,this, dashboardController);
    }
    public void addSongToQueue(Song song) {
        this.model.getPlayerModel().addSongToQueue(song);
    }

    public void deleteSongFromPlaylist(int song_id){
        int playlist_id = model.getLibraryModel().getSelectedPlaylist().getPlaylist_id();
        facade.deleteSongFromPlaylist(song_id, playlist_id);
        model.getLibraryModel().setSongContents(facade.getPlaylistSongs(playlist_id));
    }

    public void playSong(Song song) {
        this.model.getPlayerModel().playSingleSong(song);
    }
}
