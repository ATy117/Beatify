package view_builders;

import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistSearchPlaylist extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ArtistSearchPlaylist(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getPlaylistResults();
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
