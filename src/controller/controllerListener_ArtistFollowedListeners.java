package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewListener_ArtistFollowedListeners;

public class controllerListener_ArtistFollowedListeners extends Controller implements PaneController {

    public controllerListener_ArtistFollowedListeners(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        view = new viewListener_ArtistFollowedListeners(mainPane, model, this);
    }
}
