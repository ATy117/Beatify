package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewUser_ArtistMyProfile;

public class controllerUser_ArtistMyProfile extends PaneController {

    public controllerUser_ArtistMyProfile(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ArtistMyProfile(mainPane, this, dashboardController);
    }
}
