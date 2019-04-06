package view.Artist;

import controller.controllerDashboard;
import controller.Artist.controllerListener_ArtistFollowedListeners;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewListener_ArtistFollowedListeners extends View {

    public controllerListener_ArtistFollowedListeners controller;

    public viewListener_ArtistFollowedListeners(AnchorPane mainPane, controllerListener_ArtistFollowedListeners controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateListener.fxml"));
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
