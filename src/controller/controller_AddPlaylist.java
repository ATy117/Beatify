package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.scene.layout.AnchorPane;
import view.view_AddAlbum;
import view.view_AddPlaylist;

public class controller_AddPlaylist extends PaneController {
    public controller_AddPlaylist(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddPlaylist(mainPane, this, dashboardController);

    }

    public void uploadPlaylist(){
        controllerPlaylist_ArtistsAllPlaylists controllerAllAlbums = new controllerPlaylist_ArtistsAllPlaylists(dashboardController.getPaneFoundation(), dashboardController);
        dashboardController.setCurrentPane(this);
    }

}
