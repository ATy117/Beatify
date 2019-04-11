package view_builders.Artist;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerSearchables_ArtistAllSearchResults;
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
import view.viewError;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistSearchPlaylist extends builderPlaylist<AnchorPane> {

    private controllerSearchables_ArtistAllSearchResults controller;

    public builderPlaylist_ArtistSearchPlaylist(controllerSearchables_ArtistAllSearchResults controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getSearchModel().getPlaylistResults();
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

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button followButton = new Button("Follow");
            followButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(followButton);
            popup.setPopupContent(content);

            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        }
                    }
                }
            });

            followButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.followPlaylist(playlist.getPlaylist_id())) {
                        popup.hide();
                    } else {
                        System.out.println("Already Following Playlist");
                        popup.hide();
                        errorPopup = new viewError("Already Following That Playlist", albumIndiv);
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
