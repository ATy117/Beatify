package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewUser_ArtistShowArtistProfile;
import view.Listener.viewUser_ListenerShowArtistProfile;

public class controllerUser_ListenerShowArtistsProfile extends PaneController {
    public  controllerUser_ListenerShowArtistsProfile (AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ListenerShowArtistProfile(mainPane, this, dashboardController);
    }
}
