package view_builders;

import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistPlaylistOwned extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ArtistPlaylistOwned(controllerPlaylist_ArtistsAllPlaylists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getMyPlaylists();
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
