package view_builders;

import controller.Artist.controllerPlaylist_ArtistsAllPlaylists;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ArtistPlaylistFollowed  extends builderPlaylist<AnchorPane> {

    public builderPlaylist_ArtistPlaylistFollowed(controllerPlaylist_ArtistsAllPlaylists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedPlaylists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            AnchorPane albumIndiv = new AnchorPane();
            Circle albumCover = new Circle(45);
            Text text = new Text(listElements.next().getName());

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
