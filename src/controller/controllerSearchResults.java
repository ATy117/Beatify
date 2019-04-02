package controller;

import javafx.scene.layout.AnchorPane;
import view.viewQueueList;
import view.viewSearchResults;

public class controllerSearchResults extends Controller implements PaneController {

	public controllerSearchResults(AnchorPane mainPane) {
		currentPane = new viewSearchResults(mainPane);
	}

}
