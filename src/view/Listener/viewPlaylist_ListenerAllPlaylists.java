package view.Listener;

import controller.controllerDashboard;
import controller.Listener.controllerPlaylist_ListenerAllPlaylists;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewPlaylist_ListenerAllPlaylists extends View {
    public controllerPlaylist_ListenerAllPlaylists controller;

    public viewPlaylist_ListenerAllPlaylists(AnchorPane mainPane, controllerPlaylist_ListenerAllPlaylists controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templatePlaylist.fxml"));
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
