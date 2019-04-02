package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAddEditPlaylistAlbum;

public class controllerAddEditPlaylistAlbum extends Controller implements PaneController{

	public controllerAddEditPlaylistAlbum(AnchorPane mainPane) {
		currentPane = new viewAddEditPlaylistAlbum(mainPane);
	}
}
