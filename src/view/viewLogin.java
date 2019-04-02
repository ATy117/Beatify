package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class viewLogin extends View {

    public ImageView logo;
    public JFXButton loginBtn;
    public JFXPasswordField passwordField;
    public JFXTextField usernameField;
    public JFXToggleButton userTypeToggle;
    public JFXButton registerBtn;
    public controllerDashboard dashboard;

    public viewLogin (Stage primaryStage, Controller login) {

        Font.loadFont(getClass().getResource("/fonts/Poppins-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Comfortaa-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Comfortaa-Bold.ttf").toExternalForm(), 10);

        this.primaryStage = primaryStage;
        this.controller = controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateLogin.fxml"));
        loader.setController(this);

        sm = new StageManager(primaryStage);
        sm.loadScene(loader);
        sm.setWindowName("Beatify");
    }


    @Override
    public void Update() {

    }

    public void changePane(ActionEvent actionEvent) {

        if (actionEvent.getSource() == loginBtn) {
            if (userTypeToggle.selectedProperty().getValue()) {
                dashboard = new controllerArtistDashboard(primaryStage);
            }
            else {
                dashboard = new controllerListenerDashboard(primaryStage);
            }
        }
        else if (actionEvent.getSource() == registerBtn) {
            Controller register = new controllerRegister(primaryStage);
        }

    }
}
