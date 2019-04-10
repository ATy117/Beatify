package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewNotifs_ArtistNotifications;

public class controllerNotifs_ArtistNotifications extends PaneController {

    public controllerNotifs_ArtistNotifications(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewNotifs_ArtistNotifications(mainPane, this, dashboardController);
    }

    public void removeNotification(int notif_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.removeNotif(user_id, notif_id);
        this.model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
    }

    public void markAsViewed(int notif_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.setNotificationAsViewed(notif_id, user_id);
        this.model.getNotificationModel().setNotifications(facade.getAllNotifications(this.model.getProfileModel().getUser().getUser_id()));
    }
}
