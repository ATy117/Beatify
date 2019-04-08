package view_builders;

import controller.Artist.controllerSong_ArtistShowArtistAlbumSongs;
import controller.Artist.controllerSong_ArtistShowArtistPlaylistSongs;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistShowArtistPlaylistSongs extends builderSong<AnchorPane> {

    public builderSong_ArtistShowArtistPlaylistSongs(controllerSong_ArtistShowArtistPlaylistSongs controller) {
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
