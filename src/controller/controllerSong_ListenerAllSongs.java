package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_ArtistAllSongs;
import view.viewSong_ListenerAllSongs;

public class controllerSong_ListenerAllSongs extends Controller implements PaneController{
    public controllerSong_ListenerAllSongs(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewSong_ListenerAllSongs(mainPane, model, this);
    }
}
