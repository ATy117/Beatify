package view;

import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSong_ArtistAllSongs extends View {

    public viewSong_ArtistAllSongs(AnchorPane mainPane, ModelCentral model, controllerSong_ArtistAllSongs controller){
    }

    public viewAllArtists (AnchorPane mainPane, ModelCentral model, controllerAllArtists controller) {
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateAllArtists.fxml"));
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
