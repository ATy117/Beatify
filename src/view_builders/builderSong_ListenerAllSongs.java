package view_builders;

import controller.Listener.controllerSong_ListenerAllSongs;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ListenerAllSongs extends builderSong<AnchorPane> {

    public builderSong_ListenerAllSongs(controllerSong_ListenerAllSongs controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getAllSongs();
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
