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
import javafx.scene.control.ToggleGroup;
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
    @FXML ToggleGroup status;
    @FXML Circle playlistCoverCircle;

    private Playlist playlist;
    private Image privateImg, publicImg;

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
        mainPane.getStylesheets().add("view/theme.css");

        addEditLbl.setText(playlist.getOwner_name());
        playlistNameTextField.setText(playlist.getName());
        publicRadio.setSelected(true);

        publicImg = new Image("resources/publicCover.png");
        privateImg = new Image("resources/privateCover.png");

        if (!playlist.isIs_public()) {
            privateRadio.setSelected(true);
            playlistCoverCircle.setFill(new ImagePattern(privateImg));
        }
        else {
            publicRadio.setSelected(true);
            playlistCoverCircle.setFill(new ImagePattern(publicImg));
        }

    }

    public void toggle(){
        if(status.getSelectedToggle() == privateRadio){
            playlistCoverCircle.setFill(new ImagePattern(privateImg));
        }
        else
            playlistCoverCircle.setFill(new ImagePattern(publicImg));
    }

    public void doneButton() {
        String title = playlistNameTextField.getText();
        String titleCheck = title.replaceAll("\\s+", "");

        boolean is_public = true;

        if (privateRadio.isSelected())
            is_public = false;

        if (titleCheck.equals("")){
            errorPopup = new viewError("Empty Playlist Name Found", mainPane);
        } else {
            if (!controller.editPlaylist(title, is_public)){
                errorPopup = new viewError("Playlist Name Already Exists", mainPane);
            }
        }

    }


}
