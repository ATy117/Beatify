package view;

import controller.controllerSearchables_ListenerAllSearchResults;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSearchables_ListenerAllSearchResults extends View {

    public controllerSearchables_ListenerAllSearchResults controller;

    public viewSearchables_ListenerAllSearchResults(AnchorPane mainPane, ModelCentral model, controllerSearchables_ListenerAllSearchResults controller){
        this.controller = controller;
        this.model = model;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateSearchable.fxml"));
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
