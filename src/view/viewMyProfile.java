package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class viewMyProfile extends View {

	public viewMyProfile (AnchorPane mainPane) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateMyProfile.fxml"));
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
