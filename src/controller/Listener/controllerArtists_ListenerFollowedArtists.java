package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewArtist_ListenerFollowedArtists;

public class controllerArtists_ListenerFollowedArtists extends PaneController {

    public controllerArtists_ListenerFollowedArtists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedArtists(facade.getFollowedArtists(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewArtist_ListenerFollowedArtists(mainPane, this, dashboardController);
    }
}
