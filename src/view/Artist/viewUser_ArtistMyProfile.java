package view.Artist;

import com.jfoenix.controls.JFXButton;
import controller.controllerDashboard;
import controller.Artist.controllerUser_ArtistMyProfile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view.View;

import java.io.IOException;

public class viewUser_ArtistMyProfile extends View {

    public controllerUser_ArtistMyProfile controller;

    @FXML AnchorPane userContent;
    @FXML AnchorPane userHeader;

    private JFXButton logoutBtn;

    public viewUser_ArtistMyProfile(AnchorPane mainPane, controllerUser_ArtistMyProfile controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateUser.fxml"));
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
        logoutBtn = new JFXButton("Logout");

        logoutBtn.setFont(Font.font("Comfortaa", 12));

        userHeader.setLeftAnchor(logoutBtn, 300.0);
        userHeader.setTopAnchor(logoutBtn, 20.0);

        userHeader.getChildren().add(logoutBtn);

        logoutBtn.setOnMouseClicked(e -> {
            controller.logout();
        });
    }
}
