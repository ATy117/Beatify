package view_builders;

import controller.Artist.controllerSong_ArtistAllSongs;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistAllSongs extends builderSong<AnchorPane> {

    public builderSong_ArtistAllSongs(controllerSong_ArtistAllSongs controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getAllSongs();
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
