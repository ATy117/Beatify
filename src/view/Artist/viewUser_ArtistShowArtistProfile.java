package view.Artist;

import controller.Artist.controllerSong_ArtistShowListenerPlaylistSongs;
import controller.Artist.controllerUser_ArtistShowArtistsProfile;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewUser_ArtistShowArtistProfile extends View {

    //The profile of another Artist

    private controllerUser_ArtistShowArtistsProfile controller;

    public viewUser_ArtistShowArtistProfile (AnchorPane mainPane, controllerUser_ArtistShowArtistsProfile controller, controllerDashboard dashboardController){
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
