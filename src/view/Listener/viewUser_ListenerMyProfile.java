package view.Listener;

import com.jfoenix.controls.JFXButton;
import controller.controllerDashboard;
import controller.Listener.controllerUser_ListenerMyProfile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view.View;

import java.io.IOException;

public class viewUser_ListenerMyProfile extends View {

    public controllerUser_ListenerMyProfile controller;

    @FXML AnchorPane userContent;
    @FXML AnchorPane userHeader;

    private JFXButton logoutBtn;

    public viewUser_ListenerMyProfile(AnchorPane mainPane, controllerUser_ListenerMyProfile controller, controllerDashboard dashboardController){
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
    }
}
