package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAllProfiles extends View {

	public viewAllProfiles (AnchorPane mainPane, ModelCentral model) {
		this.model = model;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateAllProfiles.fxml"));
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
