package view.Artist;

import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import controller.Artist.controllerSong_ArtistShowArtistAlbumSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistShowArtistAlbumSongs extends View {

    public controllerSong_ArtistShowArtistAlbumSongs controller;

    public viewSong_ArtistShowArtistAlbumSongs(AnchorPane mainPane, controllerSong_ArtistShowArtistAlbumSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSong.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(){

    }
}
