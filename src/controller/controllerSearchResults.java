package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewQueueList;
import view.viewSearchResults;

public class controllerSearchResults extends Controller implements PaneController {

	public controllerSearchResults(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		currentPane = new viewSearchResults(mainPane, model);
	}

}
