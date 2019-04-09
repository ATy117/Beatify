package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewSong_ListenerAllSongs;

public class controllerSong_ListenerAllSongs extends PaneController {
    public controllerSong_ListenerAllSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setAllSongs(facade.getLikedSongs(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewSong_ListenerAllSongs(mainPane,this, dashboardController);
    }
}
