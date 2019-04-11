package view_builders.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import object.Playlist;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistPlaylistFollowed  extends builderPlaylist<AnchorPane> {

    private controllerPlaylist_ArtistsAllPlaylists controller;

    public builderPlaylist_ArtistPlaylistFollowed(controllerPlaylist_ArtistsAllPlaylists controller) {
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

            Image publicImg = new Image("resources/publicCover.png");
            albumCover.setFill(new ImagePattern(publicImg));

            text.setId("nameText");

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            JFXButton unfollowButton = new JFXButton("Unfollow");
            JFXButton addQueue = new JFXButton("Add Playlist to Queue");
            addQueue.setMinWidth(content.getPrefWidth());
            unfollowButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(addQueue, unfollowButton);
            popup.setPopupContent(content);

            content.getStylesheets().add("view/theme.css");
            content.setId("vboxRight");
            unfollowButton.setId("rightClickButton");
            addQueue.setId("rightClickButton");

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
                    controller.addPlaylistToQueue(playlist.getPlaylist_id());
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
