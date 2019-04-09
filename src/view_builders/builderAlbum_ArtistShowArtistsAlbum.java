package view_builders;

import com.jfoenix.controls.JFXPopup;
import controller.Artist.controllerUser_ArtistShowArtistsProfile;
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
import javafx.scene.text.TextAlignment;
import object.Album;

import java.util.ArrayList;
import java.util.List;

public class builderAlbum_ArtistShowArtistsAlbum extends builderAlbum<AnchorPane> {

    private controllerUser_ArtistShowArtistsProfile controller;

    public builderAlbum_ArtistShowArtistsAlbum(controllerUser_ArtistShowArtistsProfile controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getPeopleModel().getAlbums();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            Album album = listElements.next();
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Label text = new Label(album.getName());

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

            albumCover.setFill(new ImagePattern(new Image(album.getCover_URL().toURI().toString())));

            listProducts.add(albumIndiv);
        }

    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}

