package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewListener_ArtistFollowedListeners;

public class controllerListener_ArtistFollowedListeners extends PaneController {

    public controllerListener_ArtistFollowedListeners(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewListener_ArtistFollowedListeners(mainPane, this, dashboardController);
    }
}
