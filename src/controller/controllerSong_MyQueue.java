package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_MyQueue;

public class controllerSong_MyQueue extends PaneController{

    public controllerSong_MyQueue(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewSong_MyQueue(mainPane, model, this);
    }
}
