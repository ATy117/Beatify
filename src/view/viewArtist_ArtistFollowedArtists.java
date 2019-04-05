package view;

import controller.controllerArtist_ArtistFollowedArtists;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewArtist_ArtistFollowedArtists extends View{
    public controllerArtist_ArtistFollowedArtists controller;

    public viewArtist_ArtistFollowedArtists(AnchorPane mainPane, ModelCentral model, controllerArtist_ArtistFollowedArtists controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateArtist.fxml"));
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
