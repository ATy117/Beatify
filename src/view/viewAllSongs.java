package view;

import controller.controllerAllSongs;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAllSongs extends View {

	private controllerAllSongs controller;

	public viewAllSongs (AnchorPane mainPane, ModelCentral model, controllerAllSongs controller) {
		this.controller = controller;
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateAllSongs.fxml"));
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
}
