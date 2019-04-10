package view.Listener;

import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerUser_ListenerShowArtistsProfile;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewUser_ListenerShowArtistProfile extends View {

    public controllerUser_ListenerShowArtistsProfile controller;

    public viewUser_ListenerShowArtistProfile(AnchorPane mainPane, controllerUser_ListenerShowArtistsProfile controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateUser.fxml"));
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
