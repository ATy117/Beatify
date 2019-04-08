package view.Artist;

import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSong;
import controller.Artist.controllerSong_ArtistAllSongs;
import controller.controllerDashboard;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import view.View;

import java.io.IOException;

//Songs inside MY Album
public class viewSong_ArtistAlbumsOwnedSongs extends View {
    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private controllerSong_ArtistAlbumsOwnedSong controller;
public class viewSong_ArtistAlbumsOwnedSongs extends View {

    //Songs inside MY Album
    private controllerSong_ArtistAlbumsOwnedSongs controller;

    public viewSong_ArtistAlbumsOwnedSongs(AnchorPane mainPane, controllerSong_ArtistAlbumsOwnedSongs controller, controllerDashboard dashboardController)
    {
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
        String ALBUMNAME = "47: INSERT ARTIST ALBUM";
        String ARTISTNAME = "Album by me";
        headerLabel = new Label(ALBUMNAME);
        subheaderLabel = new Label(ARTISTNAME);
        JFXButton uploadSongBtn = new JFXButton("+ upload song");
        headerLabel.setFont(Font.font("Comfortaa", 18));
        subheaderLabel.setFont(Font.font("Comfortaa",12));
        songsHeader.setLeftAnchor(headerLabel, 285.0);
        songsHeader.setTopAnchor(headerLabel, 50.0);
        songsHeader.setLeftAnchor(subheaderLabel, 285.0);
        songsHeader.setTopAnchor(subheaderLabel, 70.0);
        songsHeader.setLeftAnchor(uploadSongBtn, 400.0);
        songsHeader.setTopAnchor(uploadSongBtn, 70.0);
        songsHeader.getChildren().add(headerLabel);
        songsHeader.getChildren().add(subheaderLabel);
        songsHeader.getChildren().add(uploadSongBtn);

        uploadSongBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }
    private void setSongs () {
        songListView.getItems().clear();
        //SETS SONGS//
        for (int i = 0; i < 5; i++) {
            //place holder values//
            AnchorPane songsIndiv = new AnchorPane();
            Text titleText = new Text("Covered in Roses");
       //     Text artistText = new Text("Dr Jekyl");
            Text albumText = new Text("In Response to Bad Events");
            Text yearText = new Text("2019");
            Text genreText = new Text("Hip Hop");

            songsIndiv.setTopAnchor(titleText, 0.0);
          //  songsIndiv.setTopAnchor(artistText, 18.0);
            songsIndiv.setTopAnchor(albumText, 0.0);
            songsIndiv.setTopAnchor(yearText, 0.0);
            songsIndiv.setTopAnchor(genreText, 18.0);

            songsIndiv.setLeftAnchor(titleText, 50.0);
          //  songsIndiv.setLeftAnchor(artistText, 50.0);
            songsIndiv.setLeftAnchor(albumText, 300.0);
            songsIndiv.setLeftAnchor(yearText, 500.0);
            songsIndiv.setLeftAnchor(genreText, 500.0);

            songsIndiv.getChildren().add(titleText);
          //  songsIndiv.getChildren().add(artistText);
            songsIndiv.getChildren().add(albumText);
            songsIndiv.getChildren().add(yearText);
            songsIndiv.getChildren().add(genreText);

            songListView.getItems().add(songsIndiv);

        }
    }



}
