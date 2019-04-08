package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
import object.Album;
import object.User;
import view.view_AddEditAlbum;

import java.io.File;
import java.time.LocalDate;

public class controller_AddEditAlbum extends PaneController {
    public controller_AddEditAlbum(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddEditAlbum(mainPane, this, dashboardController);

    }

	public boolean createAlbum(String albumName, File albumPic) {
        Album album = new Album();
        User user = model.getProfileModel().getUser();
        album.setArtist_id(user.getUser_id());
        album.setCover_URL(albumPic);
        album.setName(albumName);
        album.setDate_uploaded(LocalDate.now());
        if (facade.createAlbum(user, album)) {
            controllerAlbum_ArtistAllAlbums controllerAllAlbums = new controllerAlbum_ArtistAllAlbums(dashboardController.getPaneFoundation(), dashboardController);
            dashboardController.setCurrentPane(this);
            return true;
        } else {
            return false;
        }
	}
}
