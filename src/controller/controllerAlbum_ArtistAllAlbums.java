package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAlbum_ArtistAllAlbums;

public class controllerAlbum_ArtistAllAlbums extends PaneController {

    public controllerAlbum_ArtistAllAlbums(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewAlbum_ArtistAllAlbums(mainPane, this, dashboardController);
    }
}
