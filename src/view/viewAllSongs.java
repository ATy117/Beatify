package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAllSongs extends View {

	public viewAllSongs (AnchorPane mainPane, ModelCentral model) {
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
