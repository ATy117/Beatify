package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import controller.*;
import controller.Artist.controllerArtistDashboard;
import controller.Listener.controllerListenerDashboard;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import object.User;

public class viewLogin extends View {

    private controllerLogin controller;

    public ImageView logo;
    public JFXButton loginBtn;
    public JFXPasswordField passwordField;
    public JFXTextField usernameField;
    public JFXButton registerBtn;
    @FXML AnchorPane mainPane;

    public viewLogin (Stage primaryStage, controllerLogin login) {
        this.primaryStage = primaryStage;
        this.controller = login;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/templateLogin.fxml"));
        loader.setController(this);

        sm = new StageManager(primaryStage);
        sm.loadScene(loader);
        sm.setWindowName("Beatify");

        init();
        loadFonts();
    }

    private void init(){
        mainPane.getStylesheets().add("view/theme.css");

        RotateTransition rt = new RotateTransition(Duration.seconds(8), logo);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setAutoReverse(true);
        rt.play();
    }


    @Override
    public void Update() {

    }

    public void loadFonts() {
        Font.loadFont(getClass().getResource("/resources/fonts/Poppins-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/resources/fonts/Comfortaa-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/resources/fonts/Comfortaa-Bold.ttf").toExternalForm(), 10);
    }

    public void changePane(ActionEvent actionEvent) {

        if (actionEvent.getSource() == loginBtn) {
            //check db first if artist or user
            String username = usernameField.getText();
            String password = passwordField.getText();


            String userCheck = username.replaceAll("\\s+", "");
            String passCheck = password.replaceAll("\\s+", "");

            if (userCheck.equals("") || passCheck.equals("")){
                errorPopup = new viewError("Some Fields Are Missing", mainPane);
            } else {
                User user = controller.userLogin(username, password);
                if (user == null){
                    errorPopup = new viewError("User does not exist", mainPane);
                } else {
                    if (user.isIs_artist()) {
                        controllerDashboard dashboard = new controllerArtistDashboard(primaryStage, user);
                    } else {
                        controllerDashboard dashboard = new controllerListenerDashboard(primaryStage, user);
                    }
                }
            }

            /*
            if (username.equals("A") || username.equals("a")) {
                controllerDashboard dashboard =  new controllerArtistDashboard(primaryStage, new User());
            }
            else {
                controllerDashboard dashboard = new controllerListenerDashboard(primaryStage, new User());
            }
            */
        }
        else if (actionEvent.getSource() == registerBtn) {
            Controller register = new controllerRegister(primaryStage);
        }
    }


}
