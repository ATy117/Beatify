package view_builders;

import controller.controllerAllSongs;
import javafx.scene.layout.AnchorPane;
import object.Song;

import java.util.ArrayList;
import java.util.List;

public class SongListenerAllSongsListBuilder extends SongListBuilder<AnchorPane> {

    public SongListenerAllSongsListBuilder(controllerAllSongs controller, List<Song> listElements){
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
