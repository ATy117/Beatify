package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewQueueList;
import view.viewSearchResults;

public class controllerSearchResults extends Controller implements PaneController {

	public controllerSearchResults(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewSearchResults(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}

}
