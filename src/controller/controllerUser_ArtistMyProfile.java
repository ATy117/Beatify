package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewUser_ArtistMyProfile;

public class controllerUser_ArtistMyProfile extends PaneController {

    public controllerUser_ArtistMyProfile(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewUser_ArtistMyProfile(mainPane, model, this);
    }
}
