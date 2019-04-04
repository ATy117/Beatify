package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewQueueList;
import view.viewShowCollection;

public class controllerShowCollection extends Controller implements PaneController{

	public controllerShowCollection(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewShowCollection(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
