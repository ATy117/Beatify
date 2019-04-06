package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAlbum_ListenerFollowedAlbums;

public class controllerAlbum_ListenerFollowedAlbums extends Controller implements PaneController {

    public controllerAlbum_ListenerFollowedAlbums(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        view = new viewAlbum_ListenerFollowedAlbums(mainPane, model, this);
    }
}
