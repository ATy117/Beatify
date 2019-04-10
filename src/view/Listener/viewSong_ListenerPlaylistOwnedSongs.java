package view.Listener;

import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerSong_ListenerPlaylistOwnedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ListenerPlaylistOwnedSongs extends View {

    public controllerSong_ListenerPlaylistOwnedSongs controller;

    public viewSong_ListenerPlaylistOwnedSongs(AnchorPane mainPane, controllerSong_ListenerPlaylistOwnedSongs controller, controllerDashboard dashboardController){
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
    public void Update(){

    }
}
