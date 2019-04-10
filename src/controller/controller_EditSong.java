package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import javafx.scene.layout.AnchorPane;
import object.Album;
import object.Song;
import object.User;
import view.view_AddAlbum;
import view.view_EditSong;

import java.io.File;
import java.time.LocalDate;

public class controller_EditSong extends PaneController {
    public controller_EditSong(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_EditSong(mainPane, this, dashboardController);

    }

    public boolean editSong(String title, String genre) {
        Song song = model.getLibraryModel().getSelectedSong();
        if (title.equals(song.getSong_name())) {
            song.setGenre(genre);
            facade.updateSong(song);
            controllerSong_ArtistAlbumsOwnedSongs back = new controllerSong_ArtistAlbumsOwnedSongs(mainPane, dashboardController);
            dashboardController.setCurrentPane(back);
            return true;
        } else {
            if (facade.checkSong(song.getArtist__id(), title) == -1){
                return false;
            } else {
                song.setSong_name(title);
                facade.updateSong(song);
                controllerSong_ArtistAlbumsOwnedSongs back = new controllerSong_ArtistAlbumsOwnedSongs(mainPane, dashboardController);
                dashboardController.setCurrentPane(back);
                return true;
            }
        }



    }
}
