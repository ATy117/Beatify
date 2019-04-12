package view.Artist;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.Artist.controllerUser_ArtistMyProfile;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import object.User;
import view.View;

import java.io.File;
import java.io.IOException;

public class viewUser_ArtistMyProfile extends View {

    public controllerUser_ArtistMyProfile controller;
    private File cover;

    @FXML JFXTextField firstNameField;
    @FXML JFXTextField lastNameField;
    @FXML JFXTextField usernameField;
    @FXML JFXButton editBtn;
    @FXML Circle userPic;
    @FXML Label followingNumber;
    @FXML Label followersNumber;
    @FXML AnchorPane mainPane;
    @FXML JFXButton uploadPhotoBtn;
    private User myUser;

    public viewUser_ArtistMyProfile(AnchorPane mainPane, controllerUser_ArtistMyProfile controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateUser_MyProfile.fxml"));
        loader.setController(this);
        myUser = controller.getModel().getProfileModel().getUser();
        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Update();
    }

    @Override
    public void Update(){
        initheader();
    }

    public void logout(){
        controller.logout();
    }

    public void initheader(){
        mainPane.getStylesheets().add("view/theme.css");

        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        usernameField.setEditable(false);

        firstNameField.setText(myUser.getFirst_name());
        lastNameField.setText(myUser.getLast_name());
        usernameField.setText(myUser.getUsername());

        String url = "/resources/useryellowbluedefaultpic.png";

        if (myUser.getAvatarURL() != null) {
            url = myUser.getAvatarURL().toURI().toString();
        }

        userPic.setFill(new ImagePattern(new Image(url)));
        mainPane.getChildren().remove(uploadPhotoBtn);
    }

    public void editDetails(){
        if(editBtn.getText().equals("Edit") ){
            editBtn.setText("Done");
            firstNameField.setEditable(true);
            lastNameField.setEditable(true);
            mainPane.getChildren().add(uploadPhotoBtn);
        }
        else{
            editBtn.setText("Edit");
            firstNameField.setEditable(false);
            lastNameField.setEditable(false);
            usernameField.setEditable(false);

            myUser.setFirst_name(firstNameField.getText());
            myUser.setLast_name(lastNameField.getText());
            if (cover != null)
                myUser.setAvatarURL(cover);
            controller.editUser(myUser);
            mainPane.getChildren().remove(uploadPhotoBtn);

        }
    }

    public void uploadPhoto(){
        FileUploader uploader = new PhotoUploader(primaryStage);
        cover = uploader.getUploadedFile();

        if (cover!=null) {
            Image uploaded = new Image(cover.toURI().toString());
            userPic.setFill(new ImagePattern(uploaded));
        }
    }
}
