package controller;

import javafx.scene.layout.AnchorPane;
import view.view_AddEditAlbum;

public class controller_AddEditAlbum extends PaneController {
    public controller_AddEditAlbum(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddEditAlbum(mainPane, this, dashboardController);

    }
}
