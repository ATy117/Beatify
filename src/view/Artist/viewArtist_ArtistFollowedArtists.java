package view.Artist;

import controller.Artist.controllerArtist_ArtistFollowedArtists;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewArtist_ArtistFollowedArtists extends View {
    public controllerArtist_ArtistFollowedArtists controller;

    public viewArtist_ArtistFollowedArtists(AnchorPane mainPane, controllerArtist_ArtistFollowedArtists controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateArtist.fxml"));
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
