package view;

import FileUploaderService.FileUploader;
import FileUploaderService.MP3Uploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import controller.controller_AddSong;
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
    private File songFile = null;


    private File songFile = null;
    @FXML
    JFXComboBox songGenreCombo;
    @FXML JFXTextField songTitleTextField;
    @FXML Label artistLbl;
    @FXML Label addEditLbl;
    @FXML JFXButton uploadSongBtn;
    @FXML JFXTextField songURLField;
    @FXML Circle songCoverCircle;
    @FXML AnchorPane mainPane;

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

        init();
    }

    public void init(){
        songGenreCombo.getItems().addAll("Acoustic", "Ballad", "Classical", "Country", "Folk", "Jazz", "Pop", "Rap", "Reggae", "Religious", "Rock");
        addEditLbl.setText("Edit Song");
        mainPane.getChildren().remove(uploadSongBtn);
        mainPane.getChildren().remove(songTitleTextField);
        artistLbl.setText(controller.getModel().getLibraryModel().getSelectedSong().getArtist_name());
        songTitleTextField.setText(controller.getModel().getLibraryModel().getSelectedSong().getSong_name());
        songGenreCombo.setValue(controller.getModel().getLibraryModel().getSelectedSong().getGenre());

    }

    @Override
    public void Update(){

    }

    public void doneButton() {
        controller.editSong();

    }


}
