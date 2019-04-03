package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;

import java.io.IOException;

public class viewAllPlaylists extends View{
	public viewAllPlaylists(AnchorPane mainPane, ModelCentral model) {
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
