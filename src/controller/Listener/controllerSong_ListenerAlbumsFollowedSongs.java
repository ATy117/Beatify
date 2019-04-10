package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewSong_ListenerAlbumsFollowedSongs;

public class controllerSong_ListenerAlbumsFollowedSongs extends PaneController {
    public controllerSong_ListenerAlbumsFollowedSongs (AnchorPane mainPane, controllerDashboard dashboardController) {
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSong_ListenerAlbumsFollowedSongs(mainPane, this, dashboardController);
    }
}
