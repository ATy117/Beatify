package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerUser_ArtistShowArtistsProfile;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import view.View;
import view_builders.*;
import view_builders.Artist.builderAlbum_ArtistShowArtistsAlbum;
import view_builders.Artist.builderPlaylist_ArtistShowArtistsPlaylist;

import java.io.IOException;

public class viewUser_ArtistShowArtistProfile extends View {

    //The profile of another Artist

    private controllerUser_ArtistShowArtistsProfile controller;

    @FXML Circle userPic;
    @FXML Label userFirstLastName;
    @FXML Label userName;
    @FXML Label followerNum;
    @FXML Label followingNum;
    @FXML JFXListView contentListView;
    @FXML AnchorPane mainPane;

    Label userPlaylistLbl;
    Label userAlbumsLbl;
    TilePane playlistTile;
    TilePane albumsTile;

    public viewUser_ArtistShowArtistProfile (AnchorPane mainPane, controllerUser_ArtistShowArtistsProfile controller, controllerDashboard dashboardController){
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
        if(controller.getModel().getProfileModel().getUser().getAvatarURL()!= null)
            userPic.setFill(new ImagePattern(new Image(controller.getModel().getPeopleModel().getSelectedUser().getAvatarURL().toURI().toString())));
        else
            userPic.setFill(new ImagePattern(new Image("resources/useryellowbluedefaultpic.png")));
    }

    public void followUser(){

    }

    @Override
    public void Update(){

        contentListView.getItems().clear();

        userPlaylistLbl = new Label("User's Playlist/s");
        userAlbumsLbl = new Label("User's Album/s");

        userPlaylistLbl.setFont(Font.font("Poppins", 14));
        userAlbumsLbl.setFont(Font.font("Poppins", 14));

        contentListView.getItems().add(userPlaylistLbl);

        playlistTile = new TilePane();
        playlistTile.setMaxWidth(634.0);
        builderPlaylist builder = new builderPlaylist_ArtistShowArtistsPlaylist(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            playlistTile.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(playlistTile);

        contentListView.getItems().add(userAlbumsLbl);

        albumsTile = new TilePane();
        albumsTile.setMaxWidth(634.0);
        builderAlbum builderAlbum = new builderAlbum_ArtistShowArtistsAlbum(controller);
        Director directorAlbum = Director.getInstance();
        directorAlbum.setBuilder(builderAlbum);
        directorAlbum.construct();
        for (Object object: builderAlbum.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            albumsTile.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(albumsTile);



    }
}
