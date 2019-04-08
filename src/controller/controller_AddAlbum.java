package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
import object.Album;
import object.User;
import view.view_AddAlbum;

import java.io.File;
import java.time.LocalDate;

public class controller_AddAlbum extends PaneController {
    public controller_AddAlbum(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddAlbum(mainPane, this, dashboardController);

    }

	public boolean uploadSong(String albumName, File cover) {
        Album album = new Album();
        User user = model.getProfileModel().getUser();
        album.setDate_uploaded(LocalDate.now());
        album.setName(albumName);
        album.setCover_URL(cover);
        album.setArtist_id(user.getUser_id());
        album.setArtist_name(user.getFirst_name()+" "+user.getLast_name());
        if (facade.createAlbum(user, album)) {
            controllerAlbum_ArtistAllAlbums controllerAllAlbums = new controllerAlbum_ArtistAllAlbums(dashboardController.getPaneFoundation(), dashboardController);
            dashboardController.setCurrentPane(this);
            return true;
        } else {
            return false;
        }
	}
}
