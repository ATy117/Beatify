package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAllAlbums;

public class controllerAllAlbums extends Controller implements PaneController {

	public controllerAllAlbums(AnchorPane mainPane) {
		currentPane = new viewAllAlbums(mainPane);
	}

}
