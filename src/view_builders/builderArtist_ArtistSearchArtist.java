package view_builders;

import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ArtistSearchArtist extends builderUser<AnchorPane> {

    public builderArtist_ArtistSearchArtist(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getArtistResults();
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
