package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAllPlaylists;

public class controllerAllPlaylists extends Controller implements PaneController{

	public controllerAllPlaylists(AnchorPane centerCurrentAnchor) {
		viewAllPlaylists playlistsPane = new viewAllPlaylists(centerCurrentAnchor);
	}
}
