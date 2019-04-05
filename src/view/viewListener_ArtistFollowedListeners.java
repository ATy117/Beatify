package view;

import controller.controllerListener_ArtistFollowedListeners;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewListener_ArtistFollowedListeners extends View{

    public controllerListener_ArtistFollowedListeners controller;

    public viewListener_ArtistFollowedListeners(AnchorPane mainPane, ModelCentral model, controllerListener_ArtistFollowedListeners controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateListener.fxml"));
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
