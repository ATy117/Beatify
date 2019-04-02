package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class viewSearchResults extends View{

	public viewSearchResults (AnchorPane mainPane) {

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
