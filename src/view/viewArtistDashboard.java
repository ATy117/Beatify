package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

public class viewArtistDashboard extends viewDashboard {

	public viewArtistDashboard (Stage primaryStage, controllerDashboard controller, ModelCentral model) {
		super(primaryStage, controller, model);
		sm.setWindowName("Beatify for Artists");
	}

	@Override
	public void Update() {
		
	}
}
