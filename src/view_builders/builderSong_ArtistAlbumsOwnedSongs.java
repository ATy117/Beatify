package view_builders;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import object.Song;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistAlbumsOwnedSongs extends builderSong<AnchorPane> {

    private controllerSong_ArtistAlbumsOwnedSongs controller;

    public builderSong_ArtistAlbumsOwnedSongs(controllerSong_ArtistAlbumsOwnedSongs controller){
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getSongContents();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            Song song = listElements.next();
            AnchorPane songsIndiv = new AnchorPane();
            Text titleText = new Text(song.getSong_name());
            //     Text artistText = new Text("Dr Jekyl");
            Text albumText = new Text(song.getAlbum_name());
            Text yearText = new Text(song.getDate_uploaded().getYear() + "");
            Text genreText = new Text(song.getGenre());
            JFXButton play = new JFXButton();
            Image playImg = new Image("resources/play2.png");
            ImageView playView = new ImageView(playImg);
            play.setGraphic(playView);

            playView.setFitHeight(30.0);
            playView.setFitWidth(30.0);


            songsIndiv.setTopAnchor(titleText, 0.0);
            //  songsIndiv.setTopAnchor(artistText, 18.0);
            songsIndiv.setTopAnchor(albumText, 0.0);
            songsIndiv.setTopAnchor(yearText, 0.0);
            songsIndiv.setTopAnchor(genreText, 18.0);

            songsIndiv.setLeftAnchor(play, 2.0);
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
            songsIndiv.getChildren().add(play);

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            Button deleteButton = new Button("Delete");
            Button editButton = new Button("Edit");
            Button add_to_playlistButton = new Button ("Add to playlist");
            deleteButton.setMinWidth(content.getPrefWidth());
            editButton.setMinWidth(content.getPrefWidth());
            add_to_playlistButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(deleteButton, editButton, add_to_playlistButton);
            popup.setPopupContent(content);

            songsIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(songsIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        }
                    }
                }
            });

            deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.deleteSong(song);
                }
            });

            editButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                }
            });

            add_to_playlistButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });



            listProducts.add(songsIndiv);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
