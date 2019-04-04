package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAllSongs;

public class controllerAllSongs extends PaneController {

	public controllerAllSongs(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewAllSongs(mainPane, model, this);
	}

}
