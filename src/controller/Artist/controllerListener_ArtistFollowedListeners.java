package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewListener_ArtistFollowedListeners;

public class controllerListener_ArtistFollowedListeners extends PaneController {

    public controllerListener_ArtistFollowedListeners(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewListener_ArtistFollowedListeners(mainPane, this, dashboardController);
    }
}
