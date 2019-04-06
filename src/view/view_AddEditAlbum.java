package view;

import com.jfoenix.controls.JFXButton;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.controllerDashboard;
import controller.controller_AddEditAlbum;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class view_AddEditAlbum extends View {

    public controller_AddEditAlbum controller;

    @FXML JFXButton doneBtn;

    public view_AddEditAlbum(AnchorPane mainPane, controller_AddEditAlbum controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAddEditAlbum.fxml"));
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

    public void doneButton(){
        controller.uploadSong();
    }
}
