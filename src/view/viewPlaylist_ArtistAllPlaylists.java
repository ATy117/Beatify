package view;

import controller.controllerDashboard;
import controller.controllerPlaylist_ArtistsAllPlaylists;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewPlaylist_ArtistAllPlaylists extends View{
    public controllerPlaylist_ArtistsAllPlaylists controller;

    public viewPlaylist_ArtistAllPlaylists(AnchorPane mainPane, controllerPlaylist_ArtistsAllPlaylists controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templatePlaylist.fxml"));
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
