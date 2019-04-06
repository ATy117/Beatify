package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewSong_ListenerAllSongs;

public class controllerSong_ListenerAllSongs extends PaneController {
    public controllerSong_ListenerAllSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerAllSongs(mainPane,this, dashboardController);
    }
}
