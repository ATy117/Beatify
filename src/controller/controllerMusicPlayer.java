package controller;

import javafx.scene.layout.AnchorPane;
import view.viewMusicPlayer;

public class controllerMusicPlayer extends Controller {

	public controllerMusicPlayer(AnchorPane playerPane) {
		viewMusicPlayer musicPlayerView = new viewMusicPlayer(playerPane);
	}
}
