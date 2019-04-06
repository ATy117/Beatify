package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAllProfiles;

public class controllerAllProfiles extends PaneController {

	public controllerAllProfiles(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewAllProfiles(mainPane, model, this);
	}
}
