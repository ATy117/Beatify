package view;

import controller.controllerArtists_ListenerFollowedArtists;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewArtist_ListenerFollowedArtists extends View {
    public controllerArtists_ListenerFollowedArtists controller;

    public viewArtist_ListenerFollowedArtists(AnchorPane mainPane, controllerArtists_ListenerFollowedArtists controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateArtist.fxml"));
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
