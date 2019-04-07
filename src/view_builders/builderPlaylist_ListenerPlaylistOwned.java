package view_builders;

import controller.Listener.controllerPlaylist_ListenerAllPlaylists;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerPlaylistOwned extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ListenerPlaylistOwned(controllerPlaylist_ListenerAllPlaylists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedPlaylists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
