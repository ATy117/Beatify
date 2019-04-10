package view_builders.Artist;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import object.Album;
import view_builders.builderAlbum;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ArtistAlbumFollowed extends builderAlbum<AnchorPane> {

    private controllerAlbum_ArtistAllAlbums controller;

    public builderAlbum_ArtistAlbumFollowed (controllerAlbum_ArtistAllAlbums controller){
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedAlbums();
        this.listProducts = new ArrayList<>();
        }

        @Override
        public void build() {
            while(listElements.hasNext()) {
                Album album = listElements.next();
                AnchorPane albumIndiv = new AnchorPane();
                Circle albumCover = new Circle(45);
                Label text = new Label(album.getName());

                JFXPopup popup = new JFXPopup();
                VBox content = new VBox();
                content.setPrefWidth(65);
                Button unfollowButton = new Button("Unfollow");
                unfollowButton.setMinWidth(content.getPrefWidth());
                content.getChildren().addAll(unfollowButton);
                popup.setPopupContent(content);

                albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                            if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                                popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                            } else {
                                controller.goToFollowedList(album.getAlbum_id());
                            }
                        }
                    }
                });

                unfollowButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        controller.unfollowAlbum(album.getAlbum_id());
                        popup.hide();
                    }
                });

                albumIndiv.setLeftAnchor(albumCover, 20.0);
                albumIndiv.setTopAnchor(albumCover, 13.0);
                albumIndiv.setTopAnchor(text, 106.0);
                albumIndiv.setLeftAnchor(text, 47.0);

                albumIndiv.getChildren().add(albumCover);
                albumIndiv.getChildren().add(text);

                text.setMaxWidth(130.0);
                text.setAlignment(Pos.CENTER);
                text.setWrapText(true);
                text.setTextAlignment(TextAlignment.CENTER);

                String picurl = "/resources/albumCover.png";

                if (album.getCover_URL() != null) {
                    picurl = album.getCover_URL().toURI().toString();
                }

                albumCover.setFill(new ImagePattern(new Image(picurl)));

                listProducts.add(albumIndiv);
            }

        }

        @Override
        public List<AnchorPane> getProduct() {
            return listProducts;
        }
}