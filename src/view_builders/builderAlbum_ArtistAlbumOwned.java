package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import object.Album;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ArtistAlbumOwned extends builderAlbum<AnchorPane> {

    private controllerAlbum_ArtistAllAlbums controller;

    public builderAlbum_ArtistAlbumOwned (controllerAlbum_ArtistAllAlbums controller){
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getMyAlbums();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            Album album = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Text text = new Text(album.getName());

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button deleteButton = new Button("Delete");
            Button editButton = new Button ("Edit");
            deleteButton.setMinWidth(content.getPrefWidth());
            editButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(deleteButton, editButton);
            popup.setPopupContent(content);

            albumIndiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                            popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
                        } else {
                            controllerAlbum_ArtistAllAlbums c = controller;
                            c.goToOwnList(album.getAlbum_id());
                        }
                    }
                }
            });

            deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });

            editButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

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
