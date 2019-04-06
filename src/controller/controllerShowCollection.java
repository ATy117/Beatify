package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewShowCollection;

public class controllerShowCollection extends PaneController{

	public controllerShowCollection(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.dashboardController = controller;
		this.model = model;
		view = new viewShowCollection(mainPane, model, this);
	}

}
