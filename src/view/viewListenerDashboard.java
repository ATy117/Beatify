package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import controller.controllerDashboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

import java.io.IOException;

public class viewListenerDashboard extends viewDashboard {

	public viewListenerDashboard (Stage primaryStage, controllerDashboard controller, ModelCentral model) {
		super(primaryStage, controller, model);
		sm.setWindowName("Beatify");
	}

	@Override
	public void Update() {

	}
}
