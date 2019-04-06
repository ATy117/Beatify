package view;

import controller.controllerDashboard;
import controller.controllerSearchables_ArtistAllSearchResults;
import controller.controllerSong_ArtistAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSearchables_ArtistAllSearchResults extends View {
    public controllerSearchables_ArtistAllSearchResults controller;

    public viewSearchables_ArtistAllSearchResults(AnchorPane mainPane, controllerSearchables_ArtistAllSearchResults controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
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
