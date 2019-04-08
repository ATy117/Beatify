package view.Artist;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerSong_ArtistPlaylistsFollowedSongs;
import controller.Artist.controllerSong_ArtistPlaylistsOwnedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import view.View;

import java.io.IOException;

public class viewSong_ArtistPlaylistsOwnedSongs extends View {

    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private controllerSong_ArtistPlaylistsOwnedSongs controller;

    //Songs inside the Playlist I own

    public viewSong_ArtistPlaylistsOwnedSongs (AnchorPane mainPane, controllerSong_ArtistPlaylistsOwnedSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
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
        String PLAYLISTNAME = "51: INSERT PLAYLIST NAME OWNED";
        String ARTISTNAME = "Playlist by me";
        headerLabel = new Label(PLAYLISTNAME);
        subheaderLabel = new Label(ARTISTNAME);
        headerLabel.setFont(Font.font("Comfortaa", 18));
        subheaderLabel.setFont(Font.font("Comfortaa",12));
        songsHeader.setLeftAnchor(headerLabel, 285.0);
        songsHeader.setTopAnchor(headerLabel, 50.0);
        songsHeader.setLeftAnchor(subheaderLabel, 285.0);
        songsHeader.setTopAnchor(subheaderLabel, 70.0);
        songsHeader.getChildren().add(headerLabel);
        songsHeader.getChildren().add(subheaderLabel);
    }
    //BUILDER//

    private void setSongs () {
        songListView.getItems().clear();
        //SETS SONGS//
        for (int i = 0; i < 5; i++) {
            //place holder values//
            AnchorPane songsIndiv = new AnchorPane();
            Text titleText = new Text("Covered in Roses");
            Text artistText = new Text("Dr Jekyl");
            Text albumText = new Text("In Response to Bad Events");
            Text yearText = new Text("2019");
            Text genreText = new Text("Hip Hop");

            songsIndiv.setTopAnchor(titleText, 0.0);
            songsIndiv.setTopAnchor(artistText, 18.0);
            songsIndiv.setTopAnchor(albumText, 0.0);
            songsIndiv.setTopAnchor(yearText, 0.0);
            songsIndiv.setTopAnchor(genreText, 18.0);

            songsIndiv.setLeftAnchor(titleText, 50.0);
            songsIndiv.setLeftAnchor(artistText, 50.0);
            songsIndiv.setLeftAnchor(albumText, 300.0);
            songsIndiv.setLeftAnchor(yearText, 500.0);
            songsIndiv.setLeftAnchor(genreText, 500.0);

            songsIndiv.getChildren().add(titleText);
            songsIndiv.getChildren().add(artistText);
            songsIndiv.getChildren().add(albumText);
            songsIndiv.getChildren().add(yearText);
            songsIndiv.getChildren().add(genreText);

            songListView.getItems().add(songsIndiv);

        }
    }
}
