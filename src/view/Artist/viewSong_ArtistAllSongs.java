package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.controllerDashboard;
import controller.Artist.controllerSong_ArtistAllSongs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import view.View;
import view_builders.Director;
import view_builders.builderSong;
import view_builders.builderSong_ArtistAllSongs;

import java.io.IOException;

public class viewSong_ArtistAllSongs extends View {

    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    public controllerSong_ArtistAllSongs controller;

    public viewSong_ArtistAllSongs(AnchorPane mainPane, controllerSong_ArtistAllSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSong.fxml"));
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
        setSongs();
    }

    private void initHeader () {
        //INITIALIZES THE HEADER//
        headerLabel = new Label("All songs");
        headerLabel.setFont(Font.font("Comfortaa", 18));
        songsHeader.setLeftAnchor(headerLabel, 285.0);
        songsHeader.setTopAnchor(headerLabel, 50.0);
        songsHeader.getChildren().add(headerLabel);



    }
        //BUILDER//

    private void setSongs () {
       songListView.getItems().clear();
        //SETS SONGS//

        builderSong builder = new builderSong_ArtistAllSongs(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();

        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane) object;
            songListView.getItems().add(anchorPane);
        }

    }



}
