package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewArtist_ArtistFollowedArtists;
import view.viewSong_ArtistAllSongs;

public class controllerArtist_ArtistFollowedArtists extends Controller implements PaneController {

    public controllerArtist_ArtistFollowedArtists(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewArtist_ArtistFollowedArtists(mainPane, model, this);
    }
}
