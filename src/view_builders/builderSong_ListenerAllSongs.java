package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerSong_ListenerAllSongs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import object.Playlist;
import object.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class builderSong_ListenerAllSongs extends builderSong<AnchorPane> {

    private controllerSong_ListenerAllSongs controller;

    public builderSong_ListenerAllSongs(controllerSong_ListenerAllSongs controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getAllSongs();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            Song song  = listElements.next();

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            Button add_to_queueButton = new Button("Add to queue");
            Button add_to_playlistButton = new Button ("Add to playlist");
            Button unlikeButton = new Button ("Unlike");
            add_to_queueButton.setMinWidth(content.getPrefWidth());
            add_to_playlistButton.setMinWidth(content.getPrefWidth());
            unlikeButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(add_to_queueButton, add_to_playlistButton, unlikeButton);
            popup.setPopupContent(content);

            add_to_queueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
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
                        buttons.add(new Button (playlist.getName()));
                        buttons.get(buttons.size() - 1).setPrefWidth(200);

                        buttons.get(buttons.size() - 1).setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                    }

                    content.getChildren().addAll(buttons);
                    popup.setPopupContent(content);
                }
            });

            unlikeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
