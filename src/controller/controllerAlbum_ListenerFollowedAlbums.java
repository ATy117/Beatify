package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAlbum_ListenerFollowedAlbums;

public class controllerAlbum_ListenerFollowedAlbums extends PaneController {

    public controllerAlbum_ListenerFollowedAlbums(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewAlbum_ListenerFollowedAlbums(mainPane, this, dashboardController);
    }
}
