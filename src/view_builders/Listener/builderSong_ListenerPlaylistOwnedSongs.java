package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerSong_ListenerPlaylistOwnedSongs;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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

        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
