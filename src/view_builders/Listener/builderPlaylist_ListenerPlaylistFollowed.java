package view_builders.Listener;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerPlaylist_ListenerAllPlaylists;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import object.Playlist;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerPlaylistFollowed extends builderPlaylist<AnchorPane> {

    private controllerPlaylist_ListenerAllPlaylists controller;

    public builderPlaylist_ListenerPlaylistFollowed(controllerPlaylist_ListenerAllPlaylists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedPlaylists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            Playlist playlist = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Label text = new Label(playlist.getName());

            text.setId("nameText");

            Image publicImg = new Image("resources/publicCover.png");
            albumCover.setFill(new ImagePattern(publicImg));

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button unfollowButton = new JFXButton("Unfollow");
            Button addQueue = new JFXButton("Add Playlist to Queue");
            addQueue.setMinWidth(content.getPrefWidth());
            unfollowButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(addQueue, unfollowButton);
            popup.setPopupContent(content);

            content.getStylesheets().add("view/theme.css");
            content.setId("vboxRight");
            addQueue.setId("rightClickButton");
            unfollowButton.setId("rightClickButton");

            unfollowButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.unfollowPlaylist(playlist.getPlaylist_id());
                    popup.hide();
                }
            });

            addQueue.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    popup.hide();
                    controller.addPlaylistToQueue(playlist.getPlaylist_id());
                }
            });

            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        } else {
                            controller.goToFollowedList(playlist.getPlaylist_id());
                        }
                    }
                }
            });

            albumIndiv.setLeftAnchor(albumCover, 20.0);
            albumIndiv.setTopAnchor(albumCover, 13.0);
            albumIndiv.setTopAnchor(text, 102.0);
            albumIndiv.setLeftAnchor(text, 24.0);

            albumIndiv.getChildren().add(albumCover);
            albumIndiv.getChildren().add(text);

            listProducts.add(albumIndiv);
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
