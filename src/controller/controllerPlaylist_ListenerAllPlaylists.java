package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewPlaylist_ListenerAllPlaylists;
import view.viewSong_ArtistAllSongs;

public class controllerPlaylist_ListenerAllPlaylists extends Controller implements PaneController {

    public controllerPlaylist_ListenerAllPlaylists(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewPlaylist_ListenerAllPlaylists(mainPane, model, this);
    }
}
