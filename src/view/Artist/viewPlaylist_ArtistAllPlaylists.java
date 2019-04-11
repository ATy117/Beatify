package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.controllerDashboard;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import view.View;
import view_builders.*;
import view_builders.Artist.builderPlaylist_ArtistPlaylistFollowed;
import view_builders.Artist.builderPlaylist_ArtistPlaylistOwned;

import java.io.IOException;

public class viewPlaylist_ArtistAllPlaylists extends View {

    public controllerPlaylist_ArtistsAllPlaylists controller;

    @FXML AnchorPane playlistHeader;
    @FXML JFXListView playlistContent;
    @FXML AnchorPane mainPane;

    private Label headerLabel;
    private Label myPlaylistLbl;
    private Label followedPlaylistLbl;
    private TilePane myPlaylistList;
    private TilePane followedPlaylistList;
    private JFXButton addPlaylistBtn;


    public viewPlaylist_ArtistAllPlaylists(AnchorPane mainPane, controllerPlaylist_ArtistsAllPlaylists controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templatePlaylist.fxml"));
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
        playlistContent.getItems().clear();

        myPlaylistLbl = new Label("My Playlists");
        followedPlaylistLbl = new Label("Followed Playlists");
        myPlaylistLbl.setFont(Font.font("Poppins", 14));
        followedPlaylistLbl.setFont(Font.font("Poppins", 14));

        /*List of My Playlists*/
        myPlaylistList = new TilePane();
        myPlaylistList.setMaxWidth(634.0);
        playlistContent.getItems().add(myPlaylistLbl);
        builderPlaylist builder = new builderPlaylist_ArtistPlaylistOwned(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            myPlaylistList.getChildren().add(anchorPane);
        }
        playlistContent.getItems().add(myPlaylistList);

        /*List of Followed Playlists*/
        followedPlaylistList = new TilePane();
        playlistContent.getItems().add(followedPlaylistLbl);
        builder = new builderPlaylist_ArtistPlaylistFollowed(controller);
        director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for(Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            followedPlaylistList.getChildren().add(anchorPane);
        }
        playlistContent.getItems().add(followedPlaylistList);

    }

    public void initHeader(){
        mainPane.getStylesheets().add("view/theme.css");

        headerLabel = new Label("All Playlists");
        addPlaylistBtn = new JFXButton("+ Add Playlist");

        headerLabel.setFont(Font.font("Comfortaa", 18));

        playlistHeader.setLeftAnchor(headerLabel, 252.0);
        playlistHeader.setTopAnchor(headerLabel, 23.0);
        playlistHeader.setLeftAnchor(addPlaylistBtn, 260.0);
        playlistHeader.setTopAnchor(addPlaylistBtn, 50.0);

        playlistHeader.getChildren().add(headerLabel);
        playlistHeader.getChildren().add(addPlaylistBtn);

        addPlaylistBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changePane();
            }
        });
    }

    public void changePane(){
        controller.addPlaylists();
    }
}
