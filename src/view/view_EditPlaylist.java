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
import object.Playlist;

import java.io.File;
import java.io.IOException;

public class view_EditPlaylist extends View {

    public controller_EditPlaylist controller;

    @FXML JFXButton doneBtn;
    @FXML JFXTextField playlistNameTextField;
    @FXML Label artistLbl;
    @FXML Label addEditLbl;
    @FXML JFXRadioButton privateRadio;
    @FXML JFXRadioButton publicRadio;
    @FXML AnchorPane mainPane;

    private Playlist playlist;

    public view_EditPlaylist(AnchorPane mainPane, controller_EditPlaylist controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAddEditPlaylist.fxml"));
        loader.setController(this);

        playlist = model.getLibraryModel().getSelectedPlaylist();
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
        addEditLbl.setText(playlist.getOwner_name());
        playlistNameTextField.setText(playlist.getName());
        publicRadio.setSelected(true);
    }

    public void toggle(){

    }

    public void doneButton() {
        String title = playlistNameTextField.getText();
        String titleCheck = title.replaceAll("\\s+", "");

        boolean is_public = true;

        if (privateRadio.isSelected())
            is_public = false;

        if (titleCheck.equals("")){
            System.out.println("Empty Playlist Name Found");
            errorPopup = new viewError("Empty Playlist Name Found", mainPane);
        } else {
            if (!controller.editPlaylist(title, is_public)){
                System.out.println("Playlist Name Already Exists");
                errorPopup = new viewError("Playlist Name Already Exists", mainPane);
            }
        }

    }


}
