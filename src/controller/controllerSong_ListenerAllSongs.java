package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_ListenerAllSongs;

public class controllerSong_ListenerAllSongs extends PaneController{
    public controllerSong_ListenerAllSongs(AnchorPane mainPane, ModelCentral model, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = model;
        view = new viewSong_ListenerAllSongs(mainPane, model, this);
    }
}
