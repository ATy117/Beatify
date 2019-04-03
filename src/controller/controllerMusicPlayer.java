package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewMusicPlayer;

public class controllerMusicPlayer extends Controller {

	public controllerMusicPlayer(AnchorPane playerPane, ModelCentral model) {
		this.model = model;
		viewMusicPlayer musicPlayerView = new viewMusicPlayer(playerPane, model);
	}
}
