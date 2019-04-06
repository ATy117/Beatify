package view_builders;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
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
