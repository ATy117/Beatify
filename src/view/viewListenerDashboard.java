package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class viewListenerDashboard extends viewDashboard {


	public viewListenerDashboard (Stage primaryStage, Controller controller) {
		super(primaryStage, controller);
		sm.setWindowName("Beatify");

	}


	@Override
	public void Update() {

	}
}
