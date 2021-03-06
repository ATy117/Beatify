package controller;

import Facade.MasterFacade;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_MyQueue;

public class controllerSong_MyQueue extends PaneController{

    public controllerSong_MyQueue(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_MyQueue(mainPane, this, dashboardController);
    }
}
