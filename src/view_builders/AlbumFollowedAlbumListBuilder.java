package view_builders;

import javafx.scene.layout.AnchorPane;
import object.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumFollowedAlbumListBuilder extends AlbumListBuilder<AnchorPane> {

    public AlbumFollowedAlbumListBuilder(controllerAllSongs controller, List<Album> listElements){
        this.controller = controller;
        this.listElements = listElements;
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
