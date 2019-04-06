package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewArtist_ListenerFollowedArtists;

public class controllerArtists_ListenerFollowedArtists extends Controller implements PaneController {

    public controllerArtists_ListenerFollowedArtists(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        view = new viewArtist_ListenerFollowedArtists(mainPane, model, this);
    }
}
