package view_builders;

import controller.Artist.controllerUser_ArtistShowArtistsProfile;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistShowArtistsPlaylist extends builderPlaylist<AnchorPane> {

    private controllerUser_ArtistShowArtistsProfile controller;

    public builderPlaylist_ArtistShowArtistsPlaylist(controllerUser_ArtistShowArtistsProfile controller) {
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
