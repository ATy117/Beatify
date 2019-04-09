package view.Artist;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import controller.Artist.controllerSong_ArtistAlbumsFollowedSongs;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import object.Album;
import view.View;
import view_builders.Director;
import view_builders.builderSong;
import view_builders.builderSong_ArtistAlbumsFollowedSongs;

import java.io.IOException;

public class viewSong_ArtistAlbumsFollowedSongs extends View {

    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private controllerSong_ArtistAlbumsFollowedSongs controller;
    private Album selectedAlbum;
    //Songs inside the album I am Following

    public viewSong_ArtistAlbumsFollowedSongs(AnchorPane mainPane, controllerSong_ArtistAlbumsFollowedSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
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
        String ARTISTNAME = "Album by "+ selectedAlbum.getArtist_name();
        headerLabel = new Label(ALBUMNAME);
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

    //SET SONG IN THE LISTVIEW//
    private void setSongs () {
        songListView.getItems().clear();
        //SETS SONGS//
        builderSong builder = new builderSong_ArtistAlbumsFollowedSongs(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();

        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane) object;
            songListView.getItems().add(anchorPane);
        }
    }


}
