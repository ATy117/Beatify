package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSearchables_ArtistAllSearchResults;

public class controllerSearchables_ArtistAllSearchResults extends PaneController{

    public controllerSearchables_ArtistAllSearchResults(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSearchables_ArtistAllSearchResults(mainPane,this, dashboardController);
    }
}
