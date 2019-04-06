package view.Artist;

import controller.controllerDashboard;
import javafx.stage.Stage;
import view.viewDashboard;

public class viewArtistDashboard extends viewDashboard {

	public viewArtistDashboard (Stage primaryStage, controllerDashboard controller) {
		super(primaryStage, controller);
		sm.setWindowName("Beatify for Artist");
	}

	@Override
	public void Update() {
		
	}
}
