package view_builders.Artist;

import controller.Artist.controllerUser_ArtistShowListenerProfile;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import object.Playlist;
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
            Image publicImg = new Image("resources/publicCover.png");

            albumCover.setFill(new ImagePattern(publicImg));

            text.setFont(Font.font("Poppins", 13));

            albumIndiv.setLeftAnchor(albumCover, 20.0);
            albumIndiv.setTopAnchor(albumCover, 13.0);
            albumIndiv.setTopAnchor(text, 106.0);
            albumIndiv.setLeftAnchor(text, 45.0);

            albumIndiv.getChildren().add(albumCover);
            albumIndiv.getChildren().add(text);
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
