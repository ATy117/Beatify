package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import controller.controller_EditAlbum;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_EditAlbum extends View {

    public controller_EditAlbum controller;
    private File cover = null;

    @FXML JFXButton doneBtn;
    @FXML JFXButton uploadAlbumCoverBtn;
    @FXML JFXTextField albumNameTextField;
    @FXML Label artistLbl;
    @FXML Circle albumCoverCircle;
    @FXML Label addEditLbl;

    public view_EditAlbum(AnchorPane mainPane, controller_EditAlbum controller, controllerDashboard dashboardController){
            this.controller = controller;
            this.model = dashboardController.getModel();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAddEditAlbum.fxml"));
            loader.setController(this);

            try {
                mainPane.getChildren().setAll((AnchorPane) loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }

            init();
    }
    
    public void init(){

        addEditLbl.setText("Edit Album");
        artistLbl.setText(controller.getModel().getLibraryModel().getSelectedAlbum().getArtist_name());
        albumNameTextField.setText(controller.getModel().getLibraryModel().getSelectedAlbum().getName());
    }

    @Override
    public void Update(){


    }

    public void uploadCover () {
        FileUploader uploader = new PhotoUploader(primaryStage);
        cover = uploader.getUploadedFile();
    }

    public void doneButton() {
        String title = albumNameTextField.getText();
        String titleCheck = title.replaceAll("\\s+", "");

        if (titleCheck.equals("")){
            System.out.println("Empty Album Name Found");
        } else {
            if (!controller.editAlbum(title, cover)){
                System.out.println("Album Name Already Exists");
            }
        }

    }
}
