package view_builders;

import javafx.scene.layout.AnchorPane;
import object.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistOwnListBuilder extends PlaylistListBuilder<AnchorPane> {

    /*
    public PlaylistOwnListBuilder(controllerAllSongs controller, List<Playlist> listElements){
        this.controller = controller;
        this.listElements = listElements;
        this.listProducts = new ArrayList<>();
    }

     */

    @Override
    public void build() {

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
