package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.View;
import view.viewAddEditPlaylistAlbum;

public class controllerAddEditPlaylistAlbum extends Controller implements PaneController{

	public controllerAddEditPlaylistAlbum(AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		view = new viewAddEditPlaylistAlbum(mainPane, model, this);
	}

	@Override
	public View getPaneView() {
		return view;
	}
}
