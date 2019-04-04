package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewMyProfile;

public class controllerMyProfile extends Controller implements PaneController {

	public controllerMyProfile(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewMyProfile(mainPane, model, this);
	}
}
