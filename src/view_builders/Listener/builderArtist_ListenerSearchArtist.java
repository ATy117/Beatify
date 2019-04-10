package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerAlbum_ListenerFollowedAlbums;
import controller.Listener.controllerSearchables_ListenerAllSearchResults;
import controller.PaneController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderUser;

import java.util.ArrayList;
import java.util.List;

public class builderArtist_ListenerSearchArtist extends builderUser<AnchorPane> {

    private controllerSearchables_ListenerAllSearchResults controller;

    public builderArtist_ListenerSearchArtist(controllerSearchables_ListenerAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getArtistResults();
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
