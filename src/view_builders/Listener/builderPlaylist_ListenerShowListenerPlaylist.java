package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerUser_ListenerShowListenerProfile;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerShowListenerPlaylist extends builderPlaylist<AnchorPane> {
    private controllerUser_ListenerShowListenerProfile controller;

    public builderPlaylist_ListenerShowListenerPlaylist(controllerUser_ListenerShowListenerProfile controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getPlaylists();
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
