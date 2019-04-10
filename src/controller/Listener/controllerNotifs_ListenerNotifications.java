package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewNotifs_ArtistNotifications;
import view.Listener.viewNotifs_ListenerNotifications;

public class controllerNotifs_ListenerNotifications extends PaneController {

    public controllerNotifs_ListenerNotifications(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewNotifs_ListenerNotifications(mainPane, this, dashboardController);
    }
}
