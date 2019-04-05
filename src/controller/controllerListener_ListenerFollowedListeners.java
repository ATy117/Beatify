package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_ArtistAllSongs;

public class controllerListener_ListenerFollowedListeners extends Controller implements PaneController {

    public controllerListener_ListenerFollowedListeners(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewSong_ArtistAllSongs();
    }
}
