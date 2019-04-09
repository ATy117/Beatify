package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import object.Song;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistSearchSong extends builderSong<AnchorPane> {

    private controllerSearchables_ArtistAllSearchResults controller;

    public builderSong_ArtistSearchSong(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getSongResults();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {

            Song song = listElements.next();
            AnchorPane songsIndiv = new AnchorPane();
            Text titleText = new Text(song.getSong_name());
            Text artistText = new Text("Dr Jekyl");
            Text albumText = new Text(song.getAlbum_name());
            Text yearText = new Text(song.getDate_uploaded().getYear() + "");
            Text genreText = new Text(song.getGenre());

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

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            Button add_to_queueButton = new Button("Add to queue");
            Button add_to_playlistButton = new Button ("Add to playlist");
            Button likeButton = new Button ("Like");
            add_to_queueButton.setMinWidth(content.getPrefWidth());
            add_to_playlistButton.setMinWidth(content.getPrefWidth());
            likeButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(add_to_queueButton, add_to_playlistButton, likeButton);
            popup.setPopupContent(content);

            add_to_queueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });

            add_to_playlistButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });

            likeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
