package controller;

import javafx.scene.layout.AnchorPane;
import view.viewAllProfiles;

public class controllerAllProfiles extends Controller implements PaneController {

	public controllerAllProfiles(AnchorPane mainPane) {
		currentPane = new viewAllProfiles(mainPane);
	}
}
