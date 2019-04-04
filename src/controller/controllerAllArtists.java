package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllArtists;

public class controllerAllArtists extends Controller implements PaneController {

	public controllerAllArtists(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewAllArtists(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
