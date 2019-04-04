package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllArtists;
import view.viewAllSongs;

public class controllerAllSongs extends Controller implements PaneController {

	public controllerAllSongs(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewAllSongs(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}

}
