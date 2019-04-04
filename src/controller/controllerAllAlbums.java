package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllAlbums;

public class controllerAllAlbums extends Controller implements PaneController {

	public controllerAllAlbums(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewAllAlbums(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
