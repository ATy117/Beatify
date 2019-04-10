package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import controller.controller_AddPlaylist;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;

public class view_AddPlaylist extends View {

    public controller_AddPlaylist controller;

    @FXML JFXButton doneBtn;
    @FXML JFXTextField playlistNameTextField;
    @FXML Label artistLbl;
    @FXML JFXRadioButton privateRadio;
    @FXML JFXRadioButton publicRadio;
    @FXML Circle playlistCoverCircle;
    @FXML ToggleGroup status;
    @FXML AnchorPane mainPane;

    private Image privateImg, publicImg;

    public view_AddPlaylist(AnchorPane mainPane, controller_AddPlaylist controller, controllerDashboard dashboardController){
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

    public void init(){
        publicImg = new Image("resources/publicCover.png");
        privateImg = new Image("resources/privateCover.png");

        privateRadio.setSelected(true);
        playlistCoverCircle.setFill(new ImagePattern(privateImg));

        artistLbl.setText("by " + controller.getModel().getProfileModel().getUser().getFirst_name() + " " +
                controller.getModel().getProfileModel().getUser().getLast_name());
    }

    @Override
    public void Update(){

    }

    public void toggle(){
        if(status.getSelectedToggle() == privateRadio){
            playlistCoverCircle.setFill(new ImagePattern(privateImg));
        }
        else
            playlistCoverCircle.setFill(new ImagePattern(publicImg));
    }

    public void doneButton(){
        String name = playlistNameTextField.getText();
        String check = name.replaceAll("\\s+", "");
        boolean isPublic = true;
        if (privateRadio.isSelected())
            isPublic = false;
        else if (publicRadio.isSelected())
            isPublic = true;

        if (check.equals("")){
            System.out.println("Enter Playlist Name");
            errorPopup = new viewError("Enter Playlist Name", mainPane);
        } else {
            if (!controller.uploadPlaylist(name, isPublic)) {
                System.out.println("Playlist Not Created");
                errorPopup = new viewError("Playlist Not Created", mainPane);
            }
        }
    }
}
