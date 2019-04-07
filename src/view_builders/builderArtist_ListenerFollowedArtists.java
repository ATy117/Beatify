package view_builders;

import controller.Listener.controllerArtists_ListenerFollowedArtists;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ListenerFollowedArtists extends builderUser<AnchorPane> {

    public builderArtist_ListenerFollowedArtists(controllerArtists_ListenerFollowedArtists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getProfileModel().getFollowedArtists();
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
