package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewQueueList;
import view.viewSearchResults;

public class controllerSearchResults extends PaneController {

	public controllerSearchResults(AnchorPane mainPane, ModelCentral model, controllerDashboard  controller) {
		this.controller = controller;
		this.model = model;
		view = new viewSearchResults(mainPane, model, this);
	}


}
