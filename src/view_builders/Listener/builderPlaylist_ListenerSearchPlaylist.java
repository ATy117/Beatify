package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerSearchables_ListenerAllSearchResults;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerSearchPlaylist extends builderPlaylist<AnchorPane> {
    private controllerSearchables_ListenerAllSearchResults controller;

    public builderPlaylist_ListenerSearchPlaylist(controllerSearchables_ListenerAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getPlaylistResults();
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
