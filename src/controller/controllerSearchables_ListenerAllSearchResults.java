package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSearchables_ListenerAllSearchResults;

public class controllerSearchables_ListenerAllSearchResults extends PaneController {

    public controllerSearchables_ListenerAllSearchResults(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSearchables_ListenerAllSearchResults(mainPane, this, dashboardController);
    }
}
