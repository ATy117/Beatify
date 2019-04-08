package view.Artist;

import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
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
import object.Album;
import view.View;
import view_builders.Director;
import view_builders.builderSong;
import view_builders.builderSong_ArtistAlbumsOwnedSongs;

import java.io.IOException;

//Songs inside MY Album
public class viewSong_ArtistAlbumsOwnedSongs extends View {
    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private controllerSong_ArtistAlbumsOwnedSongs controller;
    private Album selectedAlbum;

    //Songs inside MY Album

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
        selectedAlbum = model.getLibraryModel().getSelectedAlbum();
        initHeader();
        Update();

    }

    @Override
    public void Update(){
        setSongs();
    }

    private void initHeader () {
        //INITIALIZES THE HEADER//
        String ALBUMNAME = selectedAlbum.getName();
        String ARTISTNAME = "Album by You";
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

        builderSong builder = new builderSong_ArtistAlbumsOwnedSongs(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();

        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane) object;
            songListView.getItems().add(anchorPane);
        }
    }



}
