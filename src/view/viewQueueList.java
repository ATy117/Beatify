package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class viewQueueList extends View {

	public viewQueueList (AnchorPane mainPane) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateQueueList.fxml"));
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
