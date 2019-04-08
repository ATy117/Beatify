package view.Artist;

import controller.Artist.controllerSong_ArtistShowArtistPlaylistSongs;
import controller.Artist.controllerSong_ArtistShowListenerPlaylistSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistShowListenerPlaylistSongs extends View {

    //The Songs inside the PLaylist of another Listener

    private controllerSong_ArtistShowListenerPlaylistSongs controller;

    public viewSong_ArtistShowListenerPlaylistSongs (AnchorPane mainPane, controllerSong_ArtistShowListenerPlaylistSongs controller, controllerDashboard dashboardController){
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
