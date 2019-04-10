package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerSearchables_ListenerAllSearchResults;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderSong;

import java.util.ArrayList;
import java.util.List;

public class builderSong_ListenerSearchSong extends builderSong<AnchorPane> {

    private controllerSearchables_ListenerAllSearchResults controller;

    public builderSong_ListenerSearchSong(controllerSearchables_ListenerAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getSongResults();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
