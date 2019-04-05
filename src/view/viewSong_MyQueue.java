package view;

import controller.controllerSong_ArtistAllSongs;
import controller.controllerSong_MyQueue;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSong_MyQueue extends View{

    public controllerSong_MyQueue controller;

    public viewSong_MyQueue(AnchorPane mainPane, ModelCentral model, controllerSong_MyQueue controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateSong.fxml"));
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
