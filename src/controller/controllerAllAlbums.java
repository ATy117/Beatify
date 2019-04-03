package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAllAlbums;

public class controllerAllAlbums extends Controller implements PaneController {

	public controllerAllAlbums(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		currentPane = new viewAllAlbums(mainPane, model, this);
	}

}
