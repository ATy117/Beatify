package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewAlbum_ListenerFollowedAlbums;

public class controllerAlbum_ListenerFollowedAlbums extends PaneController {

    public controllerAlbum_ListenerFollowedAlbums(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setFollowedAlbums(facade.getFollowedAlbums(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewAlbum_ListenerFollowedAlbums(mainPane, this, dashboardController);
    }
}
