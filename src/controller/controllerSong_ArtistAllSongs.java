package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_ArtistAllSongs;

public class controllerSong_ArtistAllSongs extends Controller implements PaneController {

    public controllerSong_ArtistAllSongs(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewSong_ArtistAllSongs(mainPane, model, this);
    }
}
