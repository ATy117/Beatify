package view_builders;

import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistAlbumsOwnedSongs extends builderSong<AnchorPane> {
    public builderSong_ArtistAlbumsOwnedSongs(controllerSong_ArtistAlbumsOwnedSongs controller){
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getSongContents();
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
