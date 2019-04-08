package view_builders;

import controller.Artist.controllerSearchables_ArtistAllSearchResults;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderListener_ArtistSearchListener extends builderUser<AnchorPane> {

    public builderListener_ArtistSearchListener(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getListenerResults();
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
