package view.Artist;

import controller.Artist.controllerSong_ArtistAlbumsOwnedSong;
import controller.Artist.controllerSong_ArtistAllSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ArtistAlbumsOwnedSongs extends View {

    //Songs inside MY Album
    private controllerSong_ArtistAlbumsOwnedSong controller;

    public viewSong_ArtistAlbumsOwnedSongs(AnchorPane mainPane, controllerSong_ArtistAlbumsOwnedSong controller, controllerDashboard dashboardController)
    {
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSong.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {

    }
}
