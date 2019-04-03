package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import controller.controllerLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

import java.io.IOException;

public class viewMyProfile extends View {

	public JFXButton logoutBtn;

	public viewMyProfile (AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateMyProfile.fxml"));
		loader.setController(this);

		try {
			mainPane.getChildren().setAll((AnchorPane) loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void Update() {

	}

	public void logout(ActionEvent actionEvent) {

		Controller login = new controllerLogin((Stage) logoutBtn.getScene().getWindow());
	}
}
