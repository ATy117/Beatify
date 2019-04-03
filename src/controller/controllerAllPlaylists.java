package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAllPlaylists;

public class controllerAllPlaylists extends Controller implements PaneController{

	public controllerAllPlaylists(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		currentPane = new viewAllPlaylists(mainPane, model);
	}
}
