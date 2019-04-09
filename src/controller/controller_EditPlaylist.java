package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
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



}
