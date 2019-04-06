package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewUser_ListenerMyProfile;

public class controllerUser_ListenerMyProfile extends PaneController {

    public controllerUser_ListenerMyProfile(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewUser_ListenerMyProfile(mainPane, model, this);
    }
}
