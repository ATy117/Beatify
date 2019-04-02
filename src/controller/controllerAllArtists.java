package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAllArtists;

public class controllerAllArtists extends Controller implements PaneController {

	public controllerAllArtists(AnchorPane mainPane) {
		currentPane = new viewAllArtists(mainPane);
	}
}
