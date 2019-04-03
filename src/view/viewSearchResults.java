package view;

import controller.controllerSearchResults;
import controller.controllerShowCollection;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewSearchResults extends View{

	private controllerSearchResults controller;

	public viewSearchResults (AnchorPane mainPane, ModelCentral model, controllerSearchResults controller) {
		this.controller = controller;
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateSearchResults.fxml"));
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
