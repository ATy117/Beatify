package view;

import controller.controllerAllPlaylists;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAllPlaylists extends View{

	private controllerAllPlaylists controller;

	public viewAllPlaylists(AnchorPane mainPane, ModelCentral model, controllerAllPlaylists controller) {
		this.controller = controller;
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateAllPlaylists.fxml"));
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
