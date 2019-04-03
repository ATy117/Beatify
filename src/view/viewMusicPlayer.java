package view;

import controller.controllerMusicPlayer;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

import java.io.IOException;

public class viewMusicPlayer extends View {

	public viewMusicPlayer(AnchorPane mainPane, ModelCentral model, controllerMusicPlayer controller) {
		this.controller = controller;
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateMusicPlayer.fxml"));
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
