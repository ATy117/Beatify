package view.Artist;

import controller.Artist.controllerSong_ArtistPlaylistOwnedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistPlaylistsOwnedSongs extends View {

    private controllerSong_ArtistPlaylistOwnedSongs controller;

    //Songs inside the Playlist I own

    public viewSong_ArtistPlaylistsOwnedSongs (AnchorPane mainPane, controllerSong_ArtistPlaylistOwnedSongs controller, controllerDashboard dashboardController){
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
