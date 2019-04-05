package view;

import controller.controllerSong_ArtistAllSongs;
import controller.controllerUser_ListenerMyProfile;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewUser_ListenerMyProfile extends View {

    public controllerUser_ListenerMyProfile controller;

    public viewUser_ListenerMyProfile(AnchorPane mainPane, ModelCentral model, controllerUser_ListenerMyProfile controller){
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
