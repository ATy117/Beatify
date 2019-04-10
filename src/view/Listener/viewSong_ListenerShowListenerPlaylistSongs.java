package view.Listener;

import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerSong_ListenerShowListenerPlaylistSongs;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewSong_ListenerShowListenerPlaylistSongs extends View {

    public controllerSong_ListenerShowListenerPlaylistSongs controller;

    public viewSong_ListenerShowListenerPlaylistSongs(AnchorPane mainPane, controllerSong_ListenerShowListenerPlaylistSongs controller, controllerDashboard dashboardController){
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
