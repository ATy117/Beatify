package view_builders;

import javafx.scene.layout.AnchorPane;
import object.Song;

import java.util.ArrayList;
import java.util.List;

public class SongFollowedAlbumSongsListBuilder extends SongListBuilder<AnchorPane> {

    public SongFollowedAlbumSongsListBuilder(controllerAllSongs controller, List<Song> listElements){
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
