package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllArtists;
import view.viewAllSongs;

public class controllerAllSongs extends Controller implements PaneController {

	public controllerAllSongs(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		currentPane = new viewAllSongs(mainPane, model);
	}
}
