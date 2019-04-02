package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class viewAllSongs extends View {

	public viewAllSongs (AnchorPane mainPane) {
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
