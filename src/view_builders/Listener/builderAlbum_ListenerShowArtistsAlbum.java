package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerUser_ListenerShowArtistsProfile;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderAlbum;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ListenerShowArtistsAlbum extends builderAlbum<AnchorPane> {

    public controllerUser_ListenerShowArtistsProfile controller;

    public builderAlbum_ListenerShowArtistsAlbum(controllerUser_ListenerShowArtistsProfile controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedAlbums();
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
