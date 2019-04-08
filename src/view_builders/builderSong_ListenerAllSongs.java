package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerSong_ListenerAllSongs;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
        while(listElements.hasNext()) {
            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            Button add_to_queueButton = new Button("Add to queue");
            Button add_to_playlistButton = new Button ("Add to playlist");
            Button unlikeButton = new Button ("Unlike");
            add_to_queueButton.setMinWidth(content.getPrefWidth());
            add_to_playlistButton.setMinWidth(content.getPrefWidth());
            unlikeButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(add_to_queueButton, add_to_playlistButton, unlikeButton);
            popup.setPopupContent(content);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
