package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSearchables_ListenerAllSearchResults;
import view.viewSong_ArtistAllSongs;

public class controllerSearchables_ListenerAllSearchResults extends Controller implements PaneController {

    public controllerSearchables_ListenerAllSearchResults(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewSearchables_ListenerAllSearchResults(mainPane, model, this);
    }
}
