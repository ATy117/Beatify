package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewPlaylist_ListenerAllPlaylists;

public class controllerPlaylist_ListenerAllPlaylists extends PaneController {

    public controllerPlaylist_ListenerAllPlaylists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setMyPlaylists(facade.getMyPlaylists(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getLibraryModel().setFollowedPlaylists(facade.getFollowedPlaylists(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewPlaylist_ListenerAllPlaylists(mainPane, this, dashboardController);
    }
}
