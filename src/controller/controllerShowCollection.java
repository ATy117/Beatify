package controller;

import javafx.scene.layout.AnchorPane;
import view.viewQueueList;
import view.viewShowCollection;

public class controllerShowCollection extends Controller implements PaneController{

	public controllerShowCollection(AnchorPane mainPane) {
		currentPane = new viewShowCollection(mainPane);
	}
}
