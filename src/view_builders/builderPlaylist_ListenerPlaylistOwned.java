package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerPlaylist_ListenerAllPlaylists;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerPlaylistOwned extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ListenerPlaylistOwned(controllerPlaylist_ListenerAllPlaylists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedPlaylists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button deleteButton = new Button("Delete");
            Button editButton = new Button("Edit");
            deleteButton.setMinWidth(content.getPrefWidth());
            editButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(deleteButton, editButton);
            popup.setPopupContent(content);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
