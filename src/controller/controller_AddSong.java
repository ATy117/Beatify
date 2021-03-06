package controller;

import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import javafx.scene.layout.AnchorPane;
import object.Song;
import object.User;
import view.view_AddSong;

import java.io.File;
import java.time.LocalDate;

public class controller_AddSong extends PaneController {
    public controller_AddSong(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddSong(mainPane, this, dashboardController);

    }

    public boolean addSong(String title, String genre, File songFile){
        Song song = new Song();
        int album_id = model.getLibraryModel().getSelectedAlbum().getAlbum_id();
        User user = model.getProfileModel().getUser();
        song.setSong_name(title);
        song.setAlbum_id(album_id);
        song.setArtist__id(model.getProfileModel().getUser().getUser_id());
        song.setGenre(genre);
        song.setDate_uploaded(LocalDate.now());
        song.setSong_URL(songFile);
        song.setArtist_name(user.getFirst_name()+" "+user.getLast_name());
        if (facade.uploadSong(song)){
            model.getLibraryModel().setSelectedAlbum(facade.getAlbum(album_id));
            model.getLibraryModel().setSongContents(facade.getAlbumSongs(album_id));
            controllerSong_ArtistAlbumsOwnedSongs c = new controllerSong_ArtistAlbumsOwnedSongs(mainPane, dashboardController);
            dashboardController.setCurrentPane(c);
            return true;
        } else {
            return false;
        }


    }

}
