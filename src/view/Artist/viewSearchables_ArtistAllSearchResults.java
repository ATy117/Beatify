package view.Artist;

import controller.controllerDashboard;
import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSearchables_ArtistAllSearchResults extends View {
    public controllerSearchables_ArtistAllSearchResults controller;

    public viewSearchables_ArtistAllSearchResults(AnchorPane mainPane, controllerSearchables_ArtistAllSearchResults controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
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
