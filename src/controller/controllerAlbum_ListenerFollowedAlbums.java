package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAlbum_ListenerFollowedAlbums;
import view.viewSong_ArtistAllSongs;

public class controllerAlbum_ListenerFollowedAlbums extends Controller implements PaneController {

    public controllerAlbum_ListenerFollowedAlbums(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewAlbum_ListenerFollowedAlbums(mainPane, model, this);
    }
}
