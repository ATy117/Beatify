package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import controller.controller_EditSong;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_EditSong extends View {

    public controller_EditSong controller;

    public view_EditSong(AnchorPane mainPane, controller_EditSong controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAddEditSong.fxml"));
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
