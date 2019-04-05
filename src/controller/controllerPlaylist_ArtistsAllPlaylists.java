package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewPlaylist_ArtistAllPlaylists;
import view.viewSong_ArtistAllSongs;

public class controllerPlaylist_ArtistsAllPlaylists extends Controller implements PaneController {

    public controllerPlaylist_ArtistsAllPlaylists(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewPlaylist_ArtistAllPlaylists(mainPane, model, this);
    }
}
