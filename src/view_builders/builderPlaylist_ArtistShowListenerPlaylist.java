package view_builders;

import controller.Artist.controllerUser_ArtistShowListenerProfile;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistShowListenerPlaylist extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ArtistShowListenerPlaylist(controllerUser_ArtistShowListenerProfile controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getPlaylists();
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
