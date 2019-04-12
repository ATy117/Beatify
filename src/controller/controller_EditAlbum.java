package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import javafx.scene.layout.AnchorPane;
import object.Album;
import view.view_AddAlbum;
import view.view_EditAlbum;

import java.io.File;

public class controller_EditAlbum extends PaneController {
    public controller_EditAlbum(AnchorPane mainPane, controllerDashboard dashboardController) {
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_EditAlbum(mainPane, this, dashboardController);

    }

    public void uploadSong() {
        controllerAlbum_ArtistAllAlbums controllerAllAlbums = new controllerAlbum_ArtistAllAlbums(mainPane, dashboardController);
        dashboardController.setCurrentPane(controllerAllAlbums);
    }

    public boolean editAlbum(String title, File cover) {
        Album album = model.getLibraryModel().getSelectedAlbum();
        if (title.equals(album.getName())) {
            album.setCover_URL(cover);
            facade.updateAlbum(album);
            controllerAlbum_ArtistAllAlbums back = new controllerAlbum_ArtistAllAlbums(mainPane, dashboardController);
            dashboardController.setCurrentPane(back);
            return true;
        } else {
            if (facade.checkAlbum(album.getArtist_id(), title) != -1) {
                return false;
            } else {
                album.setName(title);
                album.setCover_URL(cover);
                facade.updateAlbum(album);
                controllerAlbum_ArtistAllAlbums back = new controllerAlbum_ArtistAllAlbums(mainPane, dashboardController);
                dashboardController.setCurrentPane(back);
                return true;
            }
        }

    }
}
