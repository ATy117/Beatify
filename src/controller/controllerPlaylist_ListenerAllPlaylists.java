package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewPlaylist_ListenerAllPlaylists;

public class controllerPlaylist_ListenerAllPlaylists extends  PaneController {

    public controllerPlaylist_ListenerAllPlaylists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewPlaylist_ListenerAllPlaylists(mainPane, this, dashboardController);
    }
}
