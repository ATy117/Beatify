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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import view.View;

import java.io.IOException;

public class viewUser_ArtistMyProfile extends View {

    public controllerUser_ArtistMyProfile controller;

    @FXML JFXButton logoutBtn;

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

        initheader();
    }

    @Override
    public void Update(){

    }

    public void initheader(){

        logoutBtn.setOnMouseClicked(e -> {
            controller.logout();
        });
    }
}
