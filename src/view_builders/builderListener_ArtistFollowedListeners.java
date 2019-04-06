package view_builders;

import controller.Artist.controllerListener_ArtistFollowedListeners;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderListener_ArtistFollowedListeners extends builderUser<AnchorPane> {

    public builderListener_ArtistFollowedListeners(controllerListener_ArtistFollowedListeners controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedListeners();
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
