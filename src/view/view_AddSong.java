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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_AddSong extends View {

    public controller_AddSong controller;

    private File songFile = null;
    @FXML JFXComboBox songGenreCombo;
    @FXML JFXTextField songTitleTextField;
    @FXML Label artistLbl;
    @FXML Label addEditLbl;
    @FXML JFXButton uploadSongBtn;
    @FXML JFXTextField songURLField;
    @FXML Circle songCoverCircle;
    @FXML AnchorPane mainPane;

    public view_AddSong(AnchorPane mainPane, controller_AddSong controller, controllerDashboard dashboardController){
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
        artistLbl.setText("By "+ model.getProfileModel().getUser().getFirst_name() + " " + model.getProfileModel().getUser().getLast_name());
        songGenreCombo.getItems().addAll("Acoustic", "Ballad", "Classical", "Country", "Folk", "Jazz", "Pop", "Rap", "Reggae", "Religious", "Rock");
        songURLField.setEditable(false);

        songCoverCircle.setFill(new ImagePattern(new Image("/resources/albumCover.png")));
        artistLbl.setText("by " + controller.getModel().getProfileModel().getUser().getFirst_name() + " " +
                controller.getModel().getProfileModel().getUser().getLast_name());


    }

    @Override
    public void Update(){

    }

    public void addSongURL(){
        FileUploader uploader = new MP3Uploader(primaryStage);
        songFile = uploader.getUploadedFile();
    }

    public void doneButton() {
        String genre = (String) songGenreCombo.getValue();
        String songName = songTitleTextField.getText();

        String gCheck = genre.replaceAll("\\s+", "");
        String check = songName.replaceAll("\\s+", "");

        if (check.equals("") || gCheck.equals("")){
            System.out.println("Some Fields Are Missing");
            errorPopup = new viewError("Some Fields Are Missing", mainPane);
        } else if (songFile == null) {
            System.out.println("No File Uploaded");
            errorPopup = new viewError("No File Uploaded", mainPane);
        } else {
            if (!controller.addSong(songName, genre, songFile)) {
                System.out.println("Song not added");
                errorPopup = new viewError("Song not added", mainPane);
            }
        }

    }





}
