package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAllPlaylists;

public class controllerAllPlaylists extends PaneController{

	public controllerAllPlaylists(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.controller = controller;
		this.model = model;
		view = new viewAllPlaylists(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
