package view;

import controller.controllerAlbum_ArtistAllAlbums;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAlbum_ArtistAllAlbums extends View{

    //All Albums of Artist
    //My Albums + Followed Albums

    public controllerAlbum_ArtistAllAlbums controller;

    public viewAlbum_ArtistAllAlbums(AnchorPane mainPane, ModelCentral model, controllerAlbum_ArtistAllAlbums controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateAlbum.fxml"));
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
