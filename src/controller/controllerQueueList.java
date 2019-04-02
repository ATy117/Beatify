package controller;

import javafx.scene.layout.AnchorPane;
import view.viewQueueList;

public class controllerQueueList extends Controller implements PaneController{

	public controllerQueueList(AnchorPane mainPane) {
		currentPane = new viewQueueList(mainPane);
	}
}
