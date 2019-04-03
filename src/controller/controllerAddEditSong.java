package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewAddEditSong;

public class controllerAddEditSong extends Controller implements PaneController {

	public controllerAddEditSong(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		currentPane = new viewAddEditSong(mainPane, model, this);
	}
}
