package view;

import controller.controllerDashboard;
import controller.controllerSong_ArtistAllSongs;
import controller.controllerSong_ListenerAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSong_ListenerAllSongs extends View {

        public controllerSong_ListenerAllSongs controller;

        public viewSong_ListenerAllSongs(AnchorPane mainPane, controllerSong_ListenerAllSongs controller, controllerDashboard dashboardController){
            this.controller = controller;
            this.model = dashboardController.getModel();
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
