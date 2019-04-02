package controller;

import javafx.scene.layout.AnchorPane;
import view.viewMyProfile;

public class controllerMyProfile extends Controller implements PaneController {

	public controllerMyProfile(AnchorPane mainPane) {
		currentPane = new viewMyProfile(mainPane);
	}
}
