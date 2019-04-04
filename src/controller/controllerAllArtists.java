package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAllArtists;

public class controllerAllArtists extends PaneController {

	public controllerAllArtists(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewAllArtists(mainPane, model, this);
	}

}
