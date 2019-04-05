package view;

import controller.controllerSong_ArtistAllSongs;
import controller.controllerUser_ArtistMyProfile;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewUser_ArtistMyProfile extends View{

    public controllerUser_ArtistMyProfile controller;

    public viewUser_ArtistMyProfile(AnchorPane mainPane, ModelCentral model, controllerUser_ArtistMyProfile controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateUser.fxml"));
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
