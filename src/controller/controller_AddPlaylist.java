package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.scene.layout.AnchorPane;
import object.Playlist;
import object.User;
import view.view_AddAlbum;
import view.view_AddPlaylist;

public class controller_AddPlaylist extends PaneController {
    public controller_AddPlaylist(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddPlaylist(mainPane, this, dashboardController);

    }

    public boolean uploadPlaylist(String name, boolean isPublic){
        Playlist playlist = new Playlist();
        User user = model.getProfileModel().getUser();
        playlist.setName(name);
        playlist.setUser_id(user.getUser_id());
        playlist.setIs_public(isPublic);
        if(facade.createPlaylist(user, playlist)) {
            controllerPlaylist_ArtistsAllPlaylists controllerAllAlbums = new controllerPlaylist_ArtistsAllPlaylists(dashboardController.getPaneFoundation(), dashboardController);
            dashboardController.setCurrentPane(this);
            return true;
        } else {
            return false;
        }
    }

}
