package view.Listener;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.controllerUser_ListenerShowListenerProfile;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import view.View;
import view_builders.Artist.builderPlaylist_ArtistShowListenerPlaylist;
import view_builders.Director;
import view_builders.Listener.builderPlaylist_ListenerShowListenerPlaylist;
import view_builders.builderPlaylist;

import java.io.IOException;

public class viewUser_ListenerShowListenerProfile extends View {

    public controllerUser_ListenerShowListenerProfile controller;

    @FXML Circle userPic;
    @FXML Label userFirstLastName;
    @FXML Label userName;
    @FXML Label followerNum;
    @FXML Label followingNum;
    @FXML JFXListView profileListView;
    @FXML AnchorPane mainPane;

    Label userPlaylistLbl;
    TilePane playlistTile;

    public viewUser_ListenerShowListenerProfile(AnchorPane mainPane, controllerUser_ListenerShowListenerProfile controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateUser.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        init();
        Update();

    }

    public void init(){
        mainPane.getStylesheets().add("view/theme.css");

        userFirstLastName.setText(controller.getModel().getPeopleModel().getSelectedUser().getFirst_name() + " " +
                controller.getModel().getPeopleModel().getSelectedUser().getLast_name());
        userName.setText(controller.getModel().getPeopleModel().getSelectedUser().getUsername());
    }

    @Override
    public void Update(){

        profileListView.getItems().clear();

        userPlaylistLbl = new Label("User's Playlist/s");

        userPlaylistLbl.setFont(Font.font("Poppins", 14));

        profileListView.getItems().add(userPlaylistLbl);

        playlistTile = new TilePane();
        playlistTile.setMaxWidth(634.0);
        builderPlaylist builder = new builderPlaylist_ListenerShowListenerPlaylist(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            playlistTile.getChildren().add(anchorPane);
        }
        profileListView.getItems().add(playlistTile);

    }

    public void followUser () {

    }
}
