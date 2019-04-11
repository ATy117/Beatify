package view.Listener;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import controller.controllerDashboard;
import controller.Listener.controllerSearchables_ListenerAllSearchResults;
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
import view_builders.Listener.*;

import java.io.IOException;

public class viewSearchables_ListenerAllSearchResults extends View {

    public controllerSearchables_ListenerAllSearchResults controller;

    @FXML AnchorPane searchHeader;
    @FXML JFXListView contentListView;
    @FXML JFXTextField searchField;
    @FXML JFXButton searchBtn;
    @FXML AnchorPane mainPane;

    public TilePane artistList;
    public TilePane listenerList;
    public TilePane playlistList;
    public TilePane albumsList;
    public Label artistLbl, listenerLbl, playlistLbl, albumLbl, songLbl;

    public viewSearchables_ListenerAllSearchResults(AnchorPane mainPane, controllerSearchables_ListenerAllSearchResults controller, controllerDashboard dashboardController){
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

        songLbl = new Label("Songs:");
        albumLbl = new Label( "Albums:");
        playlistLbl = new Label("Playlists:");
        artistLbl = new Label("Artists:");
        listenerLbl = new Label("Listeners:");

        artistLbl.setId("headerLabel");
        listenerLbl.setId("headerLabel");
        playlistLbl.setId("headerLabel");
        albumLbl.setId("headerLabel");
        songLbl.setId("headerLabel");
    }

    @Override
    public void Update(){
        contentListView.getItems().clear();

        /*Search Songs*/
        contentListView.getItems().add(songLbl);
        builderSong builder = new builderSong_ListenerSearchSong(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();
        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            contentListView.getItems().add(anchorPane);
        }

        /*Search Albums*/
        contentListView.getItems().add(albumLbl);
        albumsList = new TilePane();
        builderAlbum builderAlbum = new builderAlbum_ListenerSearchAlbum(controller);
        Director directorAlbum = Director.getInstance();
        directorAlbum.setBuilder(builderAlbum);
        directorAlbum.construct();
        for (Object object: builderAlbum.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            albumsList.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(albumsList);

        /*Search Playlists*/
        contentListView.getItems().add(playlistLbl);
        playlistList = new TilePane();
        builderPlaylist builderPlaylist = new builderPlaylist_ListenerSearchPlaylist(controller);
        Director directorPlaylist = Director.getInstance();
        directorPlaylist.setBuilder(builderPlaylist);
        directorPlaylist.construct();
        for (Object object: builderPlaylist.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            playlistList.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(playlistList);

        /*Search Artists*/
        contentListView.getItems().add(artistLbl);
        artistList = new TilePane();
        builderUser builderArtist = new builderArtist_ListenerSearchArtist(controller);
        Director directorArtist = Director.getInstance();
        directorArtist.setBuilder(builderArtist);
        directorArtist.construct();
        for (Object object: builderArtist.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            artistList.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(artistList);

        /*Search Listeners*/
        contentListView.getItems().add(listenerLbl);
        listenerList = new TilePane();
        builderArtist = new builderListener_ListenerSearchListener(controller);
        directorArtist = Director.getInstance();
        directorArtist.setBuilder(builderArtist);
        directorArtist.construct();
        for (Object object: builderArtist.getProduct()){
            AnchorPane anchorPane = (AnchorPane)object;
            listenerList.getChildren().add(anchorPane);
        }
        contentListView.getItems().add(listenerList);

    }

    public void searchWord(){
        String query = searchField.getText();
        String check = query.replaceAll("\\s+", "");

        if (check.equals("")){
            errorPopup = new viewError("No Input", searchHeader);
        } else {
            controller.search(query);
        }
    }
}
