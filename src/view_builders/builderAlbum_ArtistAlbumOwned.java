package view_builders;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ArtistAlbumOwned extends builderAlbum<AnchorPane> {

    public builderAlbum_ArtistAlbumOwned (controllerAlbum_ArtistAllAlbums controller){
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getMyAlbums();
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
