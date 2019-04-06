package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewUser_ListenerMyProfile;

public class controllerUser_ListenerMyProfile extends PaneController {

    public controllerUser_ListenerMyProfile(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewUser_ListenerMyProfile(mainPane, this, dashboardController);
    }
}
