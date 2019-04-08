package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.controllerDashboard;
import controller.controller_AddEditAlbum;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_AddEditAlbum extends View {

    public controller_AddEditAlbum controller;

    @FXML JFXButton doneBtn;
    @FXML JFXButton uploadAlbumCoverBtn;
    @FXML JFXTextField albumNameTextField;
    @FXML Label artistLbl;
    @FXML Circle albumCoverCircle;

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

    public void uploadCover () {
        FileUploader uploader = new PhotoUploader(primaryStage);
        File cover = uploader.getUploadedFile();

        if (cover!=null) {
            Image uploaded = new Image(cover.toURI().toString());
            albumCoverCircle.setFill(new ImagePattern(uploaded));
        }
    }


    public void doneButton(){
        controller.uploadSong();
    }
}
