package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerSong_ListenerShowListenerPlaylistSongs;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderSong;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ListenerShowListenerPlaylisySongs extends builderSong<AnchorPane> {
    private controllerSong_ListenerShowListenerPlaylistSongs controller;

    public builderSong_ListenerShowListenerPlaylisySongs(controllerSong_ListenerShowListenerPlaylistSongs controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getSongs();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            Button add_to_queueButton = new Button("Add to queue");
            Button add_to_playlistButton = new Button ("Add to playlist");
            Button likeButton = new Button ("Like");
            add_to_queueButton.setMinWidth(content.getPrefWidth());
            add_to_playlistButton.setMinWidth(content.getPrefWidth());
            likeButton.setMinWidth(content.getPrefHeight());
            content.getChildren().addAll(add_to_queueButton, add_to_playlistButton);
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
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
