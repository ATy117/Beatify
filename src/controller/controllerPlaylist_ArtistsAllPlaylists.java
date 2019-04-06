package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewPlaylist_ArtistAllPlaylists;

public class controllerPlaylist_ArtistsAllPlaylists extends PaneController {

    public controllerPlaylist_ArtistsAllPlaylists(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewPlaylist_ArtistAllPlaylists(mainPane, model, this);
    }
}
