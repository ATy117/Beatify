package view_builders;

import controller.controllerAllSongs;
import javafx.scene.layout.AnchorPane;
import object.Song;

import java.util.ArrayList;
import java.util.List;

public class SongArtistAlbumSongsListBuilder extends SongListBuilder<AnchorPane> {

    public SongArtistAlbumSongsListBuilder(controllerAllSongs controller, List<Song> listElements){
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
