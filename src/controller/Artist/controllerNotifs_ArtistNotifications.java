package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewListener_ArtistFollowedListeners;
import view.Artist.viewNotifs_ArtistNotifications;

public class controllerNotifs_ArtistNotifications extends PaneController {

    public controllerNotifs_ArtistNotifications(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewNotifs_ArtistNotifications(mainPane, this, dashboardController);
    }
}
