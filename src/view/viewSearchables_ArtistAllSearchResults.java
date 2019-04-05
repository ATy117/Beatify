package view;

import controller.controllerSearchables_ArtistAllSearchResults;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSearchables_ArtistAllSearchResults extends View {
    public controllerSearchables_ArtistAllSearchResults controller;

    public viewSearchables_ArtistAllSearchResults(AnchorPane mainPane, ModelCentral model, controllerSearchables_ArtistAllSearchResults controller){
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
