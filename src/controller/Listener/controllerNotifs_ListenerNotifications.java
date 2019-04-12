package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Notification;
import view.Artist.viewNotifs_ArtistNotifications;
import view.Listener.viewNotifs_ListenerNotifications;

import java.util.Iterator;

public class controllerNotifs_ListenerNotifications extends PaneController {

    public controllerNotifs_ListenerNotifications(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewNotifs_ListenerNotifications(mainPane, this, dashboardController);
    }

    public void markAsViewed(int notif_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.setNotificationAsViewed(notif_id, user_id);
        this.model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
    }

    public void markAllAsViewed() {

        Iterator<Notification> listElements = this.model.getNotificationModel().getNotifications();

        while (listElements.hasNext()) {
            Notification notif = listElements.next();
            markAsViewed(notif.getNotif_id());
        }

    }
}
