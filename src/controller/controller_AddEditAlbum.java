package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
import view.view_AddEditAlbum;

public class controller_AddEditAlbum extends PaneController {
    public controller_AddEditAlbum(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddEditAlbum(mainPane, this, dashboardController);

    }

	public void uploadSong() {
		controllerAlbum_ArtistAllAlbums controllerAllAlbums = new controllerAlbum_ArtistAllAlbums(dashboardController.getPaneFoundation(), dashboardController);
		dashboardController.setCurrentPane(this);
	}
}
