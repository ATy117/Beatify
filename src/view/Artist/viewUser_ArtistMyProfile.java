package view.Artist;

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

import java.io.IOException;

public class viewUser_ArtistMyProfile extends View {

    public controllerUser_ArtistMyProfile controller;

    @FXML JFXTextField firstNameField;
    @FXML JFXTextField lastNameField;
    @FXML JFXTextField usernameField;
    @FXML JFXButton editBtn;
    @FXML Circle userPic;
    @FXML Label followingNumber;
    @FXML Label followersNumber;

    public viewUser_ArtistMyProfile(AnchorPane mainPane, controllerUser_ArtistMyProfile controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateUser_MyProfile.fxml"));
        loader.setController(this);

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
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        usernameField.setEditable(false);

        firstNameField.setText(controller.getModel().getProfileModel().getUser().getFirst_name());
        lastNameField.setText(controller.getModel().getProfileModel().getUser().getLast_name());
        usernameField.setText(controller.getModel().getProfileModel().getUser().getUsername());

        String url = "/resources/useryellowbluedefaultpic.png";

        if (this.model.getProfileModel().getUser().getAvatarURL() != null) {
            url = this.model.getProfileModel().getUser().getAvatarURL().toURI().toString();
        }

        userPic.setFill(new ImagePattern(new Image(url)));
    }

    public void editDetails(){
        if(editBtn.getText().equals("Edit") ){
            editBtn.setText("Done");
            firstNameField.setEditable(true);
            lastNameField.setEditable(true);
            usernameField.setEditable(true);
        }
        else{
            editBtn.setText("Edit");
            firstNameField.setEditable(false);
            lastNameField.setEditable(false);
            usernameField.setEditable(false);
        }
    }
}
