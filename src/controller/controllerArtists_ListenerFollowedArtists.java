package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewArtist_ListenerFollowedArtists;

public class controllerArtists_ListenerFollowedArtists extends  PaneController {

    public controllerArtists_ListenerFollowedArtists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewArtist_ListenerFollowedArtists(mainPane, this, dashboardController);
    }
}
