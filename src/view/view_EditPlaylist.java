package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import controller.controller_AddPlaylist;
import controller.controller_EditPlaylist;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_EditPlaylist extends View {

    public controller_EditPlaylist controller;

    @FXML JFXButton doneBtn;
    @FXML JFXTextField playlistNameTextField;
    @FXML Label artistLbl;
    @FXML JFXRadioButton privateRadio;
    @FXML JFXRadioButton publicRadio;

    public view_EditPlaylist(AnchorPane mainPane, controller_EditPlaylist controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAddEditPlaylist.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        init();
    }

    @Override
    public void Update(){

    }

    public void init(){

    }


}
