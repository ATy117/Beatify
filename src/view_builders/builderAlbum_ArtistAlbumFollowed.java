package view_builders;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ArtistAlbumFollowed extends builderAlbum<AnchorPane> {

public builderAlbum_ArtistAlbumFollowed (controllerAlbum_ArtistAllAlbums controller){
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