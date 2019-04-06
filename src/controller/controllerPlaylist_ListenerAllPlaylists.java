package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewPlaylist_ListenerAllPlaylists;

public class controllerPlaylist_ListenerAllPlaylists extends  PaneController {

    public controllerPlaylist_ListenerAllPlaylists(AnchorPane mainPane, ModelCentral model , controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewPlaylist_ListenerAllPlaylists(mainPane, model, this);
    }
}
