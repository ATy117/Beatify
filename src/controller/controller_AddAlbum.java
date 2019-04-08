package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
import view.view_AddAlbum;

public class controller_AddAlbum extends PaneController {
    public controller_AddAlbum(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddAlbum(mainPane, this, dashboardController);

    }

	public void uploadSong() {
		controllerAlbum_ArtistAllAlbums controllerAllAlbums = new controllerAlbum_ArtistAllAlbums(dashboardController.getPaneFoundation(), dashboardController);
		dashboardController.setCurrentPane(this);
	}
}
