package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_AddAlbum extends View {

    public controller_AddAlbum controller;
    private File cover = null;

    @FXML JFXButton doneBtn;
    @FXML JFXButton uploadAlbumCoverBtn;
    @FXML JFXTextField albumNameTextField;
    @FXML Label artistLbl;
    @FXML Circle albumCoverCircle;
    @FXML AnchorPane mainPane;

    public view_AddAlbum(AnchorPane mainPane, controller_AddAlbum controller, controllerDashboard dashboardController){
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

    private void init() {
        mainPane.getStylesheets().add("view/theme.css");

        Image albumcover = new Image("/resources/albumCover.png");
        albumCoverCircle.setFill(new ImagePattern(albumcover));
        artistLbl.setText("by " + controller.getModel().getProfileModel().getUser().getFirst_name() + " "+
                controller.getModel().getProfileModel().getUser().getLast_name());
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


    public void doneButton(){
        String albumName = albumNameTextField.getText();
        String check = albumName.replaceAll("\\s+", "");


        if (check.equals("")){
            errorPopup = new viewError("Enter Album Name", mainPane);
        } else {
            if (!controller.uploadSong(albumName, cover)) {
                errorPopup = new viewError("Album Not Created", mainPane);
            }
        }
    }
}
