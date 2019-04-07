package view_builders;

import controller.Artist.controllerArtist_ArtistFollowedArtists;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ArtistFollowedArtists extends builderUser<AnchorPane> {

    public builderArtist_ArtistFollowedArtists(controllerArtist_ArtistFollowedArtists controller) {
        this.controller= controller;
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
