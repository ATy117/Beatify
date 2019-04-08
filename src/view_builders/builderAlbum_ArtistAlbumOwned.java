package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ArtistAlbumOwned extends builderAlbum<AnchorPane> {

    public builderAlbum_ArtistAlbumOwned (controllerAlbum_ArtistAllAlbums controller){
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getMyAlbums();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Text text = new Text(listElements.next().getName());

            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button deleteButton = new Button("Delete");
            Button editButton = new Button ("Edit");
            deleteButton.setMinWidth(content.getPrefWidth());
            editButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(deleteButton, editButton);
            popup.setPopupContent(content);

            albumCover.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        popup.show(albumIndiv, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
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
