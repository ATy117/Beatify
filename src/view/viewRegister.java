package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.Controller;
import controller.controllerLogin;
import controller.controllerRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;

public class viewRegister extends View{

    private controllerRegister controller;

    public Circle imageCircle;
    public JFXButton uploadBtn;
    public JFXTextField firstNameField;
    public JFXTextField lastnameField;
    public JFXTextField usernameField;
    public JFXPasswordField passwordField;
    public JFXButton doneBtn;
    public JFXPasswordField confirmPassField;
    public JFXRadioButton listenerToggle;
    public JFXRadioButton artistToggle;
    public JFXButton backBtn;

    @FXML AnchorPane mainPane;

    private File profilePic = null;

    public viewRegister(Stage primaryStage, controllerRegister controller) {
        this.primaryStage = primaryStage;
        this.controller = controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/templateRegister.fxml"));
        loader.setController(this);

        sm = new StageManager(primaryStage);
        sm.loadScene(loader);
        sm.setWindowName("Register");

        init();
    }

    private void init() {
        mainPane.getStylesheets().add("view/theme.css");

        Image defpic = new Image("resources/useryellowbluedefaultpic.png");
        imageCircle.setFill(new ImagePattern(defpic));
        listenerToggle.setSelected(true);
    }

    @Override
    public void Update() {

    }

    public void uploadPhoto(ActionEvent actionEvent) {
        FileUploader uploader = new PhotoUploader(primaryStage);
        profilePic = uploader.getUploadedFile();

        if (profilePic!=null) {
            Image uploaded = new Image(profilePic.toURI().toString());
            imageCircle.setFill(new ImagePattern(uploaded));
        }
    }

    public void registerUser(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String passwordConfirm = confirmPassField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastnameField.getText();
        boolean isArtist = artistToggle.isSelected();

        String firstCheck = firstName.replaceAll("\\s+", "");
        String lastCheck = lastName.replaceAll("\\s+", "");
        String userCheck = username.replaceAll("\\s+", "");
        String passCheck = password.replaceAll("\\s+", "");
        String passCheckCheck = passwordConfirm.replaceAll("\\s+", "");

        if (firstCheck.equals("") || lastCheck.equals("") || userCheck.equals("") || passCheck.equals("") || passCheckCheck.equals("")){
            System.out.println("Some Fields Are Missing");
            errorPopup = new viewError("Some Fields Are Missing", mainPane);
        } else if ( ! password.equals(passwordConfirm)) {
            System.out.println("Passwords Do Not Match");
            errorPopup = new viewError("Passwords Do Not Match", mainPane);
        } else {
            if (controller.register(username, password, firstName, lastName, isArtist, profilePic)){
                System.out.println("Successfully Created Account");
            } else {
                System.out.println("This Account Exists Already");
            }
        }

    }

    public void changePane(ActionEvent actionEvent) {
        if (actionEvent.getSource() == backBtn) {
            Controller login = new controllerLogin(primaryStage);
        }
    }
}
