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
    @FXML AnchorPane mainPane;

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
        mainPane.getStylesheets().add("view/theme.css");

        Image albumcover = new Image("/resources/albumCover.png");
        albumCoverCircle.setFill(new ImagePattern(albumcover));

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

        if (cover!=null) {
            Image uploaded = new Image(cover.toURI().toString());
            albumCoverCircle.setFill(new ImagePattern(uploaded));
        }
    }

    public void doneButton() {
        String title = albumNameTextField.getText();
        String titleCheck = title.replaceAll("\\s+", "");

        if (titleCheck.equals("")){
            errorPopup = new viewError("Empty Album Name Found", mainPane);
        } else {
            if (!controller.editAlbum(title, cover)){
                errorPopup = new viewError("Album Name Already Exists", mainPane);
            }
        }

    }
}
