package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewListener_ListenerFollowedListeners;

public class controllerListener_ListenerFollowedListeners extends PaneController {

    public controllerListener_ListenerFollowedListeners(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewListener_ListenerFollowedListeners(mainPane, this, dashboardController);
    }
}
