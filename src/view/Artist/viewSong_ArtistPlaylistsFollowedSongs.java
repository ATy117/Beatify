package view.Artist;

import controller.Artist.controllerSong_ArtistPlaylistFollowedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistPlaylistsFollowedSongs extends View {

    //Songs inside the Playlist I am following

    private controllerSong_ArtistPlaylistFollowedSongs controller;
    //Songs inside the album I am Following

    public viewSong_ArtistPlaylistsFollowedSongs (AnchorPane mainPane, controllerSong_ArtistPlaylistFollowedSongs controller, controllerDashboard dashboardController){
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
