package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewUser_ArtistShowListenerProfile;
import view.Listener.viewUser_ListenerShowListenerProfile;

public class controllerUser_ListenerShowListenerProfile extends PaneController {

    public  controllerUser_ListenerShowListenerProfile (AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ListenerShowListenerProfile(   mainPane,this, dashboardController);
    }
}
