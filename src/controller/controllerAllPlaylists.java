package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllPlaylists;

public class controllerAllPlaylists extends Controller implements PaneController{

	public controllerAllPlaylists(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewAllPlaylists(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
