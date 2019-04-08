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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import view.View;

import java.io.IOException;

public class viewUser_ArtistMyProfile extends View {

    public controllerUser_ArtistMyProfile controller;

    @FXML JFXListView userContent;
    @FXML AnchorPane userHeader;

    private JFXButton logoutBtn, editBtn;
    private Circle userPic;
    private JFXTextField userFirstname, userLastname, username;
    private Label followers, following, followerNum, followingNum;
    private Label playlistLbl, albumLbl, myPlaylistLbl, followingPlaylistLbl;
    private Label myAlbumLbl, followingAlbumLbl;
    private TilePane myPlaylistTilePane, followingPlaylistTilePane;
    private TilePane myAlbumsTilePane;

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
        userContent.getItems().clear();

        myPlaylistLbl = new Label("My Playlists");
        followingPlaylistLbl = new Label("Followed Playlists");

        myPlaylistLbl.setFont(Font.font("Comfortaa", 14));
        followingPlaylistLbl.setFont(Font.font("Comfortaa", 14));

        userContent.getItems().add(myPlaylistLbl);

    }

    public void initheader(){
        userPic = new Circle(50.0);
        logoutBtn = new JFXButton("Logout");
        editBtn = new JFXButton("Edit");
        userFirstname = new JFXTextField(controller.getModel().getProfileModel().getUser().getFirst_name());
        userLastname = new JFXTextField(controller.getModel().getProfileModel().getUser().getLast_name());
        username = new JFXTextField(controller.getModel().getProfileModel().getUser().getUsername());

        logoutBtn.setFont(Font.font("Comfortaa", 12));
        editBtn.setFont(Font.font("Comfortaa", 12));
        userFirstname.setFont(Font.font("Poppins", 16));
        userLastname.setFont(Font.font("Poppins", 16));
        username.setFont(Font.font("Poppins", 16));

        userHeader.setLeftAnchor(logoutBtn, 230.0);
        userHeader.setTopAnchor(logoutBtn, 110.0);
        userHeader.setLeftAnchor(userPic, 45.0);
        userHeader.setTopAnchor(userPic, 20.0);
        userHeader.setLeftAnchor(userFirstname, 170.0);
        userHeader.setTopAnchor(userFirstname, 20.0);
        userHeader.setLeftAnchor(userLastname, 390.0);
        userHeader.setTopAnchor(userLastname, 20.0);
        userHeader.setLeftAnchor(username, 170.0);
        userHeader.setTopAnchor(username, 60.0);
        userHeader.setLeftAnchor(editBtn, 170.0);
        userHeader.setTopAnchor(editBtn, 110.0);

        userFirstname.setEditable(false);
        userLastname.setEditable(false);
        username.setEditable(false);

        userHeader.getChildren().add(logoutBtn);
        userHeader.getChildren().add(userPic);
        userHeader.getChildren().add(userFirstname);
        userHeader.getChildren().add(userLastname);
        userHeader.getChildren().add(username);
        userHeader.getChildren().add(editBtn);

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Edit");
            }
        });

        logoutBtn.setOnMouseClicked(e -> {
            controller.logout();
        });
    }
}
