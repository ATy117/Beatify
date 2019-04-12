package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerUser_ArtistShowListenerProfile;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import view.View;
import view_builders.*;
import view_builders.Artist.builderPlaylist_ArtistShowListenerPlaylist;

import java.io.IOException;

public class viewUser_ArtistShowListenerProfile extends View {

    //The profile of another Listener

    private controllerUser_ArtistShowListenerProfile controller;

    @FXML Circle userPic;
    @FXML Label userFirstLastName;
    @FXML Label userName;
    @FXML Label followerNum;
    @FXML Label followingNum;
    @FXML JFXListView contentListView;
    @FXML AnchorPane mainPane;

    Label userPlaylistLbl;
    TilePane playlistTile;

    public viewUser_ArtistShowListenerProfile (AnchorPane mainPane, controllerUser_ArtistShowListenerProfile controller, controllerDashboard dashboardController){
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

        contentListView.getItems().clear();

        userPlaylistLbl = new Label("User's Playlist/s");

        userPlaylistLbl.setFont(Font.font("Poppins", 14));

        contentListView.getItems().add(userPlaylistLbl);

        playlistTile = new TilePane();
        playlistTile.setMaxWidth(634.0);
        builderPlaylist builder = new builderPlaylist_ArtistShowListenerPlaylist(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            playlistTile.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(playlistTile);

    }

    public void followUser () {

    }
}
