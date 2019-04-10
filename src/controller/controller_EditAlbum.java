package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import javafx.scene.layout.AnchorPane;
import view.view_AddAlbum;
import view.view_EditAlbum;

public class controller_EditAlbum extends PaneController {
    public controller_EditAlbum(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_EditAlbum(mainPane, this, dashboardController);

    }

    public void uploadSong() {
        controllerAlbum_ArtistAllAlbums controllerAllAlbums = new controllerAlbum_ArtistAllAlbums(dashboardController.getPaneFoundation(), dashboardController);
        dashboardController.setCurrentPane(controllerAllAlbums);
    }

    public void editAlbum() {
        controllerAlbum_ArtistAllAlbums back = new controllerAlbum_ArtistAllAlbums(mainPane, dashboardController);
        dashboardController.setCurrentPane(back);
    }
}
