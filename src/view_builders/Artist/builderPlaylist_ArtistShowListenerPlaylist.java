package view_builders.Artist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerUser_ArtistShowListenerProfile;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import object.Playlist;
import view.viewError;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistShowListenerPlaylist extends builderPlaylist<AnchorPane> {

    private controllerUser_ArtistShowListenerProfile controller;

    public builderPlaylist_ArtistShowListenerPlaylist(controllerUser_ArtistShowListenerProfile controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getPlaylists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {

        while (listElements.hasNext()) {
            Playlist p = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Label text = new Label(p.getName());

            text.setId("nameText");

            Image publicImg = new Image("resources/publicCover.png");

            albumCover.setFill(new ImagePattern(publicImg));

            text.setFont(Font.font("Poppins", 13));

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(150);
            JFXButton followButton = new JFXButton("Follow");
            followButton.setMinWidth(content.getPrefWidth());
            JFXButton addQueue = new JFXButton("Add Playlist to Queue");
            addQueue.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(addQueue, followButton);
            popup.setPopupContent(content);

            content.getStylesheets().add("view/theme.css");
            content.setId("vboxRight");
            followButton.setId("rightClickButton");
            addQueue.setId("rightClickButton");


            followButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.followPlaylist(p.getPlaylist_id())) {
                        popup.hide();
                    } else {
                        popup.hide();
                        errorPopup = new viewError("Already Following That Playlist", albumIndiv);
                    }
                }
            });

            addQueue.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.addPlaylistToQueue(p.getPlaylist_id());
                }
            });

            albumIndiv.setLeftAnchor(albumCover, 20.0);
            albumIndiv.setTopAnchor(albumCover, 13.0);
            albumIndiv.setTopAnchor(text, 106.0);
            albumIndiv.setLeftAnchor(text, 26.0);

            albumIndiv.getChildren().add(albumCover);
            albumIndiv.getChildren().add(text);
            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        } else {
                            controller.goToPlaylistList(p.getPlaylist_id());
                        }
                    }
                }
            });
            listProducts.add(albumIndiv);

            text.setMaxWidth(100.0);
            text.setAlignment(Pos.CENTER);
            text.setWrapText(true);
            text.setTextAlignment(TextAlignment.CENTER);
        }

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}
