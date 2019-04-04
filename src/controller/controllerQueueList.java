package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewQueueList;

public class controllerQueueList extends Controller implements PaneController{

	public controllerQueueList(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewQueueList(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
