package view;

import controller.controllerSong_ArtistAllSongs;
import controller.controllerSong_ListenerAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSong_ListenerAllSongs extends View {

        public controllerSong_ListenerAllSongs controller;

        public viewSong_ListenerAllSongs(AnchorPane mainPane, ModelCentral model, controllerSong_ListenerAllSongs controller){
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
