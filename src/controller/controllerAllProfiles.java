package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllProfiles;

public class controllerAllProfiles extends Controller implements PaneController {

	public controllerAllProfiles(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewAllProfiles(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
