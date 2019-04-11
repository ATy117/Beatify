package view.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import view.View;
import view.viewError;
import view_builders.*;
import view_builders.Artist.*;

import java.io.IOException;

public class viewSearchables_ArtistAllSearchResults extends View {

    public controllerSearchables_ArtistAllSearchResults controller;

    @FXML AnchorPane searchHeader;
    @FXML JFXListView searchContent;
    @FXML JFXTextField searchField;
    @FXML JFXButton searchBtn;
    @FXML AnchorPane mainPane;

    public TilePane artistList;
    public TilePane listenerList;
    public TilePane playlistList;
    public TilePane albumsList;
    public Label artistLbl, listenerLbl, playlistLbl, albumLbl, songLbl;

    public viewSearchables_ArtistAllSearchResults(AnchorPane mainPane, controllerSearchables_ArtistAllSearchResults controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
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

        Image search = new Image("resources/searchButton.png");
        ImageView searchView = new ImageView(search);

        searchView.setFitWidth(37);
        searchView.setFitHeight(37);

        searchBtn.setGraphic(searchView);
    }

    @Override
    public void Update(){
        searchContent.getItems().clear();

        songLbl = new Label("Songs:");
        albumLbl = new Label( "Albums:");
        playlistLbl = new Label("Playlists:");
        artistLbl = new Label("Artists:");
        listenerLbl = new Label("Listeners:");

        /*Search Songs*/
        searchContent.getItems().add(songLbl);
        builderSong builder = new builderSong_ArtistSearchSong(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            searchContent.getItems().add(anchorPane);
        }

        /*Search Albums*/
        searchContent.getItems().add(albumLbl);
        albumsList = new TilePane();
        builderAlbum builderAlbum = new builderAlbum_ArtistSearchAlbum(controller);
        Director directorAlbum = Director.getInstance();
        directorAlbum.setBuilder(builderAlbum);
        directorAlbum.construct();
        for (Object object: builderAlbum.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            albumsList.getChildren().add(anchorPane);
        }
        searchContent.getItems().add(albumsList);

        /*Search Playlists*/
        searchContent.getItems().add(playlistLbl);
        playlistList = new TilePane();
        builderPlaylist builderPlaylist = new builderPlaylist_ArtistSearchPlaylist(controller);
        Director directorPlaylist = Director.getInstance();
        directorPlaylist.setBuilder(builderPlaylist);
        directorPlaylist.construct();
        for (Object object: builderPlaylist.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            playlistList.getChildren().add(anchorPane);
        }
        searchContent.getItems().add(playlistList);

        /*Search Artists*/
        searchContent.getItems().add(artistLbl);
        artistList = new TilePane();
        builderUser builderArtist = new builderArtist_ArtistSearchArtist(controller);
        Director directorArtist = Director.getInstance();
        directorArtist.setBuilder(builderArtist);
        directorArtist.construct();
        for (Object object: builderArtist.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            artistList.getChildren().add(anchorPane);
        }
        searchContent.getItems().add(artistList);

        /*Search Listeners*/
        searchContent.getItems().add(listenerLbl);
        listenerList = new TilePane();
        builderArtist = new builderListener_ArtistSearchListener(controller);
        directorArtist = Director.getInstance();
        directorArtist.setBuilder(builderArtist);
        directorArtist.construct();
        for (Object object: builderArtist.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            listenerList.getChildren().add(anchorPane);
        }
        searchContent.getItems().add(listenerList);

    }

    public void searchWord(){
        String query = searchField.getText();
        String check = query.replaceAll("\\s+", "");

        if (check.equals("")){
            System.out.println("No Input");
            errorPopup = new viewError("No Input", searchHeader);
        } else {
            controller.search(query);
        }
    }
}
