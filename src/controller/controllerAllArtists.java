package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllArtists;

public class controllerAllArtists extends PaneController {

	public controllerAllArtists(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.controller = controller;
		this.model = model;
		view = new viewAllArtists(mainPane, model, this);
	}

}
