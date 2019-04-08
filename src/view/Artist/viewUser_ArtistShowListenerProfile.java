package view.Artist;

import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import controller.Artist.controllerUser_ArtistShowListenerProfile;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import view.View;

import java.io.IOException;

public class viewUser_ArtistShowListenerProfile extends View {

    //The profile of another Listener

    public controllerUser_ArtistShowListenerProfile controller;

    public viewUser_ArtistShowListenerProfile(AnchorPane mainPane, controllerUser_ArtistShowListenerProfile controller, controllerDashboard dashboardController){
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
