package view.Artist;

import controller.Artist.controllerSong_ArtistShowArtistAlbumSongs;
import controller.Artist.controllerSong_ArtistShowArtistPlaylistSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistShowArtistPlaylistSongs extends View {

    //Songs inside the Playlist of a different Artist
    private controllerSong_ArtistShowArtistPlaylistSongs controller;

    public viewSong_ArtistShowArtistPlaylistSongs (AnchorPane mainPane, controllerSong_ArtistShowArtistPlaylistSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
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
