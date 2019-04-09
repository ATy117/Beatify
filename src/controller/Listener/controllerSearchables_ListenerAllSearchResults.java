package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewSearchables_ListenerAllSearchResults;

public class controllerSearchables_ListenerAllSearchResults extends PaneController {

    public controllerSearchables_ListenerAllSearchResults(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSearchables_ListenerAllSearchResults(mainPane, this, dashboardController);
    }
}
