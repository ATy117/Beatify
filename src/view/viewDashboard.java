package view;

import com.jfoenix.controls.JFXButton;
import controller.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class viewDashboard extends View {

	protected controllerDashboard controller;

	public AnchorPane rightCurrentAnchor;
	public AnchorPane centerCurrentAnchor;
	public JFXButton profileBtn;
	public JFXButton playlistsBtn;
	public JFXButton albumsBtn;
	public JFXButton listenersBtn;
	public JFXButton artistBtn;
	public JFXButton songsBtn;
	public JFXButton searchBtn;
	public JFXButton queueBtn;
	public JFXButton notificationsBtn;
	@FXML public VBox buttonVbox;
	@FXML AnchorPane mainPane;
	protected controllerMusicPlayer musicPlayer;
	protected PaneController currentPaneController;


	public viewDashboard (Stage primaryStage, controllerDashboard controller) {
		this.model = controller.getModel();
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateDashboard.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);

		musicPlayer = new controllerMusicPlayer(rightCurrentAnchor, controller);
		controller.setMusicPlayer(musicPlayer);

		controller.setPaneFoundation(centerCurrentAnchor);
	}

	public void showNotifCue() {
		Platform.runLater( () -> {
			notificationsBtn.setStyle("-fx-background-color: #7c0a02");
			System.out.println("Red!");
		});
	}

	public void unshowNotifCue() {
		notificationsBtn.setStyle("-fx-background-color: #1c6575");
	}

}
