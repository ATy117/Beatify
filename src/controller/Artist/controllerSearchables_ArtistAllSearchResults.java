package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewSearchables_ArtistAllSearchResults;

public class controllerSearchables_ArtistAllSearchResults extends PaneController {

    public controllerSearchables_ArtistAllSearchResults(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSearchables_ArtistAllSearchResults(mainPane,this, dashboardController);
    }
}
