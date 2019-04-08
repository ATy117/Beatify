package view.Artist;

import com.jfoenix.controls.JFXButton;
import controller.controllerDashboard;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view.View;

import java.io.IOException;

public class viewPlaylist_ArtistAllPlaylists extends View {

    public controllerPlaylist_ArtistsAllPlaylists controller;

    @FXML AnchorPane playlistHeader;
    @FXML AnchorPane playlistContent;

    private Label headerLabel;
    private Label myPlaylistLbl;

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

    }

    @Override
    public void Update(){

    }

    public void initHeader(){
        headerLabel = new Label("All Playlists");

        headerLabel.setFont(Font.font("Comfortaa", 18));

        playlistHeader.setLeftAnchor(headerLabel, 252.0);
        playlistHeader.setTopAnchor(headerLabel, 23.0);

        playlistHeader.getChildren().add(headerLabel);

        /*Builder*/

    }
}
