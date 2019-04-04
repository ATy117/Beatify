package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAllAlbums;

public class controllerAllAlbums extends PaneController {

	public controllerAllAlbums(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewAllAlbums(mainPane, model, this);
	}
}
