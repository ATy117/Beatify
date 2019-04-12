package controller.Listener;

import controller.Artist.controllerSong_ArtistShowArtistAlbumSongs;
import controller.Artist.controllerSong_ArtistShowArtistPlaylistSongs;
import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewUser_ArtistShowArtistProfile;
import view.Listener.viewUser_ListenerShowArtistProfile;

public class controllerUser_ListenerShowArtistsProfile extends PaneController {
    public  controllerUser_ListenerShowArtistsProfile (AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ListenerShowArtistProfile(mainPane, this, dashboardController);
    }

    public boolean followAlbum(int album_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.followAlbum(user_id, album_id);
    }

    public boolean followPlaylist(int playlist_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        return facade.followPlaylist(user_id, playlist_id);
    }

    public void goToAlbumList(int album_id){
        model.getPeopleModel().setSelectedAlbum(facade.getAlbum(album_id));
        model.getPeopleModel().setSongs(facade.getAlbumSongs(album_id));
        controllerSong_ListenerShowArtistAlbumSongs c = new controllerSong_ListenerShowArtistAlbumSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public void goToPlaylistList(int playlist_id){
        model.getPeopleModel().setSelectedPlaylist(facade.getPlaylist(playlist_id));
        model.getPeopleModel().setSongs(facade.getPlaylistSongs(playlist_id));
        controllerSong_ListenerShowArtistPlaylistSongs c = new controllerSong_ListenerShowArtistPlaylistSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public void addPlaylistToQueue(int playlist_id){
        model.getPlayerModel().addPlaylistToQueue(facade.getPlaylistSongs(playlist_id));
    }
}
