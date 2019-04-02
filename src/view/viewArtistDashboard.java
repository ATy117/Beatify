package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class viewArtistDashboard extends viewDashboard {

	public viewArtistDashboard (Stage primaryStage, Controller controller) {
		super(primaryStage, controller);
		sm.setWindowName("Beatify for Artists");
	}

	@Override
	public void Update() {
		
	}
}
