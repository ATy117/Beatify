package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAlbum_ArtistAllAlbums;

public class controllerAlbum_ArtistAllAlbums extends Controller implements PaneController {

    public controllerAlbum_ArtistAllAlbums(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        view = new viewAlbum_ArtistAllAlbums(mainPane, model, this);
    }
}
