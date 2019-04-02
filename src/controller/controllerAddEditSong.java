package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAddEditSong;

public class controllerAddEditSong extends Controller implements PaneController {

	public controllerAddEditSong(AnchorPane mainPane) {
		currentPane = new viewAddEditSong(mainPane);
	}
}
