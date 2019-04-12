package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Listener.viewSearchables_ListenerAllSearchResults;

public class controllerSearchables_ListenerAllSearchResults extends PaneController {

    public controllerSearchables_ListenerAllSearchResults(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSearchables_ListenerAllSearchResults(mainPane, this, dashboardController);
    }
    public void search(String query){
        int user_id = model.getProfileModel().getUser().getUser_id();
        this.model.getSearchModel().setSongResults(facade.searchSongs(query, user_id));
        this.model.getSearchModel().setAlbumResults(facade.searchAlbums(query, user_id));
        this.model.getSearchModel().setPlaylistResults(facade.searchPlaylists(query, user_id));
        this.model.getSearchModel().setArtistResults(facade.searchArtists(query, user_id));
        this.model.getSearchModel().setListenerResults(facade.searchListeners(query, user_id));
    }

    public boolean followAlbum(int album_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.followAlbum(user_id, album_id);
    }

    public boolean followPlaylist(int playlist_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.followPlaylist(user_id, playlist_id);
    }

    public boolean followUser(int followed_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.followUser(user_id, followed_id);
    }

    public void playSong(Song song) {
        this.model.getPlayerModel().playSingleSong(song);
    }

    public boolean addSongToPlaylist (int song_id, int playlist_id){
        return facade.addSongToPlaylist(song_id, playlist_id);
    }

    public void addSongToQueue(Song song) {
        this.model.getPlayerModel().addSongToQueue(song);
    }

    public boolean likeSong(int song_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.likeSong(user_id, song_id);
    }

    public void addPlaylistToQueue(int playlist_id){
        model.getPlayerModel().addPlaylistToQueue(facade.getPlaylistSongs(playlist_id));
    }
}
