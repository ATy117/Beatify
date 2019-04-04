package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAddEditSong;

public class controllerAddEditSong extends PaneController {

	public controllerAddEditSong(AnchorPane mainPane, ModelCentral model, controllerDashboard controller) {
		this.controller = controller;
		this.model = model;
		view = new viewAddEditSong(mainPane, model, this);
	}

}
