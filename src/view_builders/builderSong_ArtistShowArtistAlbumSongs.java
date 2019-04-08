package view_builders;

import controller.Artist.controllerSong_ArtistShowArtistAlbumSongs;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistShowArtistAlbumSongs extends builderSong<AnchorPane> {

    public builderSong_ArtistShowArtistAlbumSongs(controllerSong_ArtistShowArtistAlbumSongs controller) {
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
