package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewArtist_ListenerFollowedArtists;
import view.viewSong_ArtistAllSongs;

public class controllerArtists_ListenerFollowedArtists extends Controller implements PaneController {

    public controllerArtists_ListenerFollowedArtists(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewArtist_ListenerFollowedArtists(mainPane, model, this);
    }
}
