package view.Artist;

import controller.controllerDashboard;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewPlaylist_ArtistAllPlaylists extends View {
    public controllerPlaylist_ArtistsAllPlaylists controller;

    public viewPlaylist_ArtistAllPlaylists(AnchorPane mainPane, controllerPlaylist_ArtistsAllPlaylists controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templatePlaylist.fxml"));
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
