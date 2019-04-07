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

import java.io.IOException;

public class viewSong_ArtistAllSongs extends View {

    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
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
        createContextMenu();
        Update();
    }

    @Override
    public void Update(){

    }

    private void initHeader (){
        //INITIALIZES THE HEADER//
        headerLabel = new Label("All songs");
        headerLabel.setFont(Font.font("Comfortaa", 18));
        songsHeader.setLeftAnchor(headerLabel, 285.0);
        songsHeader.setTopAnchor(headerLabel, 50.0);
        songsHeader.getChildren().add(headerLabel);

        //BUILDER//


        //SETS SONGS//
        for (int i = 0; i<5;i++){
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

    private void createContextMenu ()
    {
        ContextMenu contextMenu = new ContextMenu();

        //CREATE MENUITEM ADD TO QUEUE
        MenuItem addToQueue = new MenuItem("Add to Queue");
        addToQueue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add to Queue. Woo!");
            }
        });
        contextMenu.getItems().add(addToQueue);

        //MENU ITEM ADD TO PLAYLIST INCOMPLETE
        for (int i = 0; i<5; i++){
             MenuItem addToPlaylist = new MenuItem("Playlist "+ i);

             addToPlaylist.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) {
                     System.out.println("Added to Playlist. Woo!");
                 }
             });

             contextMenu.getItems().add(addToPlaylist);
        }


        songListView.setContextMenu(contextMenu);


    }
}
