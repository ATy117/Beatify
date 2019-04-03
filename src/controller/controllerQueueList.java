package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewQueueList;

public class controllerQueueList extends Controller implements PaneController{

	public controllerQueueList(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		currentPane = new viewQueueList(mainPane, model);
	}
}
