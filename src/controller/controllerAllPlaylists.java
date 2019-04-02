package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAllPlaylists;

public class controllerAllPlaylists extends Controller implements PaneController{

	public controllerAllPlaylists(AnchorPane mainPane) {
		currentPane = new viewAllPlaylists(mainPane);
	}
}
