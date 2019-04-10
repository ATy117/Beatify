package view.Listener;

import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerSong_ListenerPlaylistFollowedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ListenerPlaylistFollowedSongs extends View {

    public controllerSong_ListenerPlaylistFollowedSongs controller;

    public viewSong_ListenerPlaylistFollowedSongs(AnchorPane mainPane, controllerSong_ListenerPlaylistFollowedSongs controller, controllerDashboard dashboardController){
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
