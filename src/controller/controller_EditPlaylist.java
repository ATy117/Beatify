package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import controller.Artist.controllerSong_ArtistPlaylistOwnedSongs;
import controller.Listener.controllerPlaylist_ListenerAllPlaylists;
import javafx.scene.layout.AnchorPane;
import object.Playlist;
import object.User;
import view.view_AddAlbum;
import view.view_AddPlaylist;
import view.view_EditPlaylist;

public class controller_EditPlaylist extends PaneController {
    public controller_EditPlaylist(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_EditPlaylist(mainPane, this, dashboardController);

    }


    public boolean editPlaylist(String title, boolean is_public) {
        User user = model.getProfileModel().getUser();
        Playlist playlist = model.getLibraryModel().getSelectedPlaylist();
        if (title.equals(playlist.getName())) {
            playlist.setIs_public(is_public);
            facade.updatePlaylist(playlist);
            if (user.isIs_artist()) {
                controllerPlaylist_ArtistsAllPlaylists back = new controllerPlaylist_ArtistsAllPlaylists(mainPane, dashboardController);
                dashboardController.setCurrentPane(back);
                return true;
            } else {
                controllerPlaylist_ListenerAllPlaylists back = new controllerPlaylist_ListenerAllPlaylists(mainPane, dashboardController);
                dashboardController.setCurrentPane(back);
                return true;
            }
        } else {
            if (facade.checkPlaylist(playlist.getUser_id(), title) != -1) {
                return false;
            } else {
                playlist.setName(title);
                playlist.setIs_public(is_public);
                if (user.isIs_artist()) {
                    controllerPlaylist_ArtistsAllPlaylists back = new controllerPlaylist_ArtistsAllPlaylists(mainPane, dashboardController);
                    dashboardController.setCurrentPane(back);
                    return true;
                } else {
                    controllerPlaylist_ListenerAllPlaylists back = new controllerPlaylist_ListenerAllPlaylists(mainPane, dashboardController);
                    dashboardController.setCurrentPane(back);
                    return true;
                }
            }
        }


    }
}
