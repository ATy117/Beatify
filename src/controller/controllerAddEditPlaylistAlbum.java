package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAddEditPlaylistAlbum;

public class controllerAddEditPlaylistAlbum extends PaneController{

	public controllerAddEditPlaylistAlbum(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewAddEditPlaylistAlbum(mainPane, model, this);
	}
}
