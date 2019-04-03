package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import controller.*;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class viewLogin extends View {

    public ImageView logo;
    public JFXButton loginBtn;
    public JFXPasswordField passwordField;
    public JFXTextField usernameField;
    public JFXButton registerBtn;
    private controllerLogin controller;

    public viewLogin (Stage primaryStage, controllerLogin login) {

        Font.loadFont(getClass().getResource("/fonts/Poppins-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Comfortaa-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Comfortaa-Bold.ttf").toExternalForm(), 10);

        this.primaryStage = primaryStage;
        this.controller = login;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("templateLogin.fxml"));
        loader.setController(this);

        sm = new StageManager(primaryStage);
        sm.loadScene(loader);
        sm.setWindowName("Beatify");

        init();
    }

    private void init(){
        RotateTransition rt = new RotateTransition(Duration.seconds(8), logo);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setAutoReverse(true);
        rt.play();
    }


    @Override
    public void Update() {

    }

    public void changePane(ActionEvent actionEvent) {

        if (actionEvent.getSource() == loginBtn) {
            //check db first if artist or user
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (controller.userLogin(username, password)) {
                controllerDashboard dashboard = new controllerListenerDashboard(primaryStage);
            }
        }
        else if (actionEvent.getSource() == registerBtn) {
            Controller register = new controllerRegister(primaryStage);
        }

    }
}
