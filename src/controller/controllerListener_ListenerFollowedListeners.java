package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewListener_ListenerFollowedListeners;

public class controllerListener_ListenerFollowedListeners extends Controller implements PaneController {

    public controllerListener_ListenerFollowedListeners(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        view = new viewListener_ListenerFollowedListeners(mainPane, model, this);
    }
}
