package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewListener_ListenerFollowedListeners;

public class controllerListener_ListenerFollowedListeners extends PaneController {

    public controllerListener_ListenerFollowedListeners(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewListener_ListenerFollowedListeners(mainPane, this, dashboardController);
    }
}
