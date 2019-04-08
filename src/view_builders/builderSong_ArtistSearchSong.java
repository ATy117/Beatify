package view_builders;

import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ArtistSearchSong extends builderSong<AnchorPane> {

    public builderSong_ArtistSearchSong(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getSongResults();
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
