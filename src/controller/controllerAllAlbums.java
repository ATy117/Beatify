package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllAlbums;

public class controllerAllAlbums extends PaneController {

	public controllerAllAlbums(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.controller = controller;
		this.model = model;
		view = new viewAllAlbums(mainPane, model, this);
	}
}
