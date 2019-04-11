package view.Listener;

import com.jfoenix.controls.JFXListView;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import view.View;
import view_builders.Artist.builderArtist_ArtistFollowedArtists;
import view_builders.Director;
import view_builders.Listener.builderAlbum_ListenerAlbumFollowed;
import view_builders.builderAlbum;
import view_builders.builderUser;

import java.io.IOException;

public class viewAlbum_ListenerFollowedAlbums extends View {

    // All Albums the Listener is Following
    // List of Albums only

    public controllerAlbum_ListenerFollowedAlbums controller;

    @FXML AnchorPane albumsHeader;
    @FXML JFXListView contentListView;
    @FXML AnchorPane mainPane;

    private Label headerLabel;
    private TilePane artistList;


    public viewAlbum_ListenerFollowedAlbums(AnchorPane mainPane, controllerAlbum_ListenerFollowedAlbums controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateAlbum.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        initHeader();
        Update();
    }

    @Override
    public void Update(){
        contentListView.getItems().clear();

        artistList = new TilePane();

        builderAlbum builder = new builderAlbum_ListenerAlbumFollowed(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            artistList.getChildren().add(anchorPane);
        }

        contentListView.getItems().add(artistList);
    }

    public void initHeader(){
        mainPane.getStylesheets().add("view/theme.css");
        headerLabel = new Label("All Followed Albums");

        headerLabel.setId("songHeader");

        albumsHeader.setLeftAnchor(headerLabel, 252.0);
        albumsHeader.setTopAnchor(headerLabel, 23.0);

        albumsHeader.getChildren().add(headerLabel);

    }
}
