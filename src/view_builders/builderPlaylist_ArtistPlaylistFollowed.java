package view_builders;

import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistPlaylistFollowed  extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ArtistPlaylistFollowed(controllerPlaylist_ArtistsAllPlaylists controller) {
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
