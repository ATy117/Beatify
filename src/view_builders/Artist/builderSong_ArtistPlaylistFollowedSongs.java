package view_builders.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerSong_ArtistPlaylistFollowedSongs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import object.Playlist;
import object.Song;
import view.viewError;
import view_builders.builderSong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class builderSong_ArtistPlaylistFollowedSongs extends builderSong<AnchorPane> {
    private controllerSong_ArtistPlaylistFollowedSongs controller;

    public builderSong_ArtistPlaylistFollowedSongs(controllerSong_ArtistPlaylistFollowedSongs controller){
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
            JFXButton add_to_queueButton = new JFXButton("Add to queue");
            JFXButton add_to_playlistButton = new JFXButton ("Add to playlist");
            add_to_queueButton.setMinWidth(content.getPrefWidth());
            add_to_playlistButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(add_to_queueButton, add_to_playlistButton);
            popup.setPopupContent(content);

            content.getStylesheets().add("view/theme.css");
            content.setId("vboxRight");
            add_to_playlistButton.setId("rightClickButton");
            add_to_queueButton.setId("rightClickButton");

            play.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.playSong(song);
                }
            });

            add_to_queueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    popup.hide();
                    controller.addSongToQueue(song);
                }
            });

            add_to_playlistButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    content.getChildren().clear();
                    content.setPrefWidth(200);
                    ArrayList <Button> buttons = new ArrayList<>();

                    Iterator<Playlist> listPlaylistElements = controller.getModel().getLibraryModel().getMyPlaylists();

                    while (listPlaylistElements.hasNext()){
                        Playlist playlist = listPlaylistElements.next();
                        Button b = new Button (playlist.getName());
                        buttons.add(b);
                        b.setPrefWidth(200);

                        b.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (controller.addSongToPlaylist(song.getSong_id(), playlist.getPlaylist_id())) {
                                    popup.hide();
                                } else {
                                    popup.hide();
                                    errorPopup = new viewError("Song Not Added to Playlist Anymore", songsIndiv);
                                }
                            }
                        });

                    }

                    content.getChildren().addAll(buttons);
                    popup.setPopupContent(content);
                }
            });

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

            listProducts.add(songsIndiv);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
