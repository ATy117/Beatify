package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewQueueList;

public class controllerQueueList extends PaneController{

	public controllerQueueList(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewQueueList(mainPane, model, this);
	}
}
