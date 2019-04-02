package controller;

import javafx.scene.layout.AnchorPane;
import view.View;
import view.viewAllArtists;
import view.viewAllSongs;

public class controllerAllSongs extends Controller implements PaneController {

	public controllerAllSongs(AnchorPane mainPane) {
		currentPane = new viewAllSongs(mainPane);
	}
}
