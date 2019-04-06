package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewListener_ListenerFollowedListeners;

public class controllerListener_ListenerFollowedListeners extends PaneController {

    public controllerListener_ListenerFollowedListeners(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewListener_ListenerFollowedListeners(mainPane, model, this);
    }
}
