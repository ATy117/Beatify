package view_builders.Listener;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerSong_ListenerPlaylistOwnedSongs;
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
import view.viewError;
import view_builders.builderSong;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ListenerPlaylistOwnedSongs extends builderSong<AnchorPane> {
    private controllerSong_ListenerPlaylistOwnedSongs controller;

    public builderSong_ListenerPlaylistOwnedSongs(controllerSong_ListenerPlaylistOwnedSongs controller) {
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
            Text artistText = new Text(song.getArtist_name());
            Text albumText = new Text(song.getAlbum_name());
            Text yearText = new Text(song.getDate_uploaded().getYear() + "");
            Text genreText = new Text(song.getGenre());

            titleText.setId("songText");
            artistText.setId("songText");
            albumText.setId("songText");
            yearText.setId("songText");
            genreText.setId("songText");

            JFXButton play = new JFXButton();
            Image playImg = new Image("resources/play2.png");
            ImageView playView = new ImageView(playImg);
            play.setGraphic(playView);

            playView.setFitHeight(30.0);
            playView.setFitWidth(30.0);

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
            songsIndiv.setLeftAnchor(play, 2.0);

            songsIndiv.getChildren().add(titleText);
            songsIndiv.getChildren().add(artistText);
            songsIndiv.getChildren().add(albumText);
            songsIndiv.getChildren().add(yearText);
            songsIndiv.getChildren().add(genreText);
            songsIndiv.getChildren().add(play);

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            Button likeButton = new JFXButton("Like");
            Button add_to_queueButton = new JFXButton("Add to queue");
            Button deleteButton = new JFXButton("Delete from Playlist");
            likeButton.setMinWidth(content.getPrefWidth());
            deleteButton.setMinWidth(content.getPrefWidth());
            add_to_queueButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(likeButton, deleteButton, add_to_queueButton);
            popup.setPopupContent(content);

            content.getStylesheets().add("view/theme.css");
            content.setId("vboxRight");
            deleteButton.setId("rightClickButton");
            add_to_queueButton.setId("rightClickButton");
            likeButton.setId("rightClickButton");




            play.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.playSong(song);
                }
            });

            likeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.likeSong(song.getSong_id())){
                        popup.hide();
                    } else {
                        popup.hide();
                        errorPopup = new viewError("Song Already Liked", songsIndiv);
                    }
                }
            });
            deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.deleteSongFromPlaylist(song.getSong_id());
                    popup.hide();
                }
            });

            add_to_queueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    popup.hide();
                    controller.addSongToQueue(song);
                }
            });

            songsIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY))
                            popup.show(songsIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                    }
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
