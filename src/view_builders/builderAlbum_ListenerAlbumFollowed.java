package view_builders;

import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ListenerAlbumFollowed extends builderAlbum<AnchorPane> {

    public builderAlbum_ListenerAlbumFollowed(controllerAlbum_ListenerFollowedAlbums controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedAlbums();
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
