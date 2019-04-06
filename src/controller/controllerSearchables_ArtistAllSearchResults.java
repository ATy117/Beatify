package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSearchables_ArtistAllSearchResults;

public class controllerSearchables_ArtistAllSearchResults extends PaneController{

    public controllerSearchables_ArtistAllSearchResults(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewSearchables_ArtistAllSearchResults(mainPane, model, this);
    }
}
