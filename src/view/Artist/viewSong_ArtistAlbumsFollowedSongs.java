package view.Artist;

import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import controller.Artist.controllerSong_ArtistAlbumsFollowedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistAlbumsFollowedSongs extends View {

    //Songs inside the album I am Following

    public controllerSong_ArtistAlbumsFollowedSongs controller;

    public viewSong_ArtistAlbumsFollowedSongs(AnchorPane mainPane, controllerSong_ArtistAlbumsFollowedSongs controller, controllerDashboard dashboardController){
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
