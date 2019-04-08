package view_builders;

import controller.Artist.controllerSong_ArtistShowArtistPlaylistSongs;
import controller.Artist.controllerSong_ArtistShowListenerPlaylistSongs;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistShowListenerPlaylistSongs extends builderSong<AnchorPane> {

    public builderSong_ArtistShowListenerPlaylistSongs(controllerSong_ArtistShowListenerPlaylistSongs controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getSongs();
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
