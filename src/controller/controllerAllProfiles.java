package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllProfiles;

public class controllerAllProfiles extends PaneController {

	public controllerAllProfiles(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.controller = controller;
		this.model = model;
		view = new viewAllProfiles(mainPane, model, this);
	}
}
