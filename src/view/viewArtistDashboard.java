package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class viewArtistDashboard extends viewDashboard {
	public AnchorPane rightCurrentAnchor;
	public AnchorPane centerCurrentAnchor;
	public JFXButton searchBtn;
	public JFXButton songsBtn;
	public JFXButton artistBtn;
	public JFXButton listenersBtn;
	public JFXButton albumsBtn;
	public JFXButton playlistsBtn;
	public JFXButton profileBtn;

	public viewArtistDashboard (Stage primaryStage, Controller controller) {
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateDashboard.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);
		sm.setWindowName("Beatify Artist");
	}

	@Override
	public void Update() {
		
	}
}
