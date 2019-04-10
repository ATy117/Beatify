package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerUser_ListenerShowArtistsProfile;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerShowArtistPlaylist extends builderPlaylist<AnchorPane> {

    private controllerUser_ListenerShowArtistsProfile controller;

    public builderPlaylist_ListenerShowArtistPlaylist(controllerUser_ListenerShowArtistsProfile controller) {
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
