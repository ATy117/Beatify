package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import controller.PaneController;
import controller.controllerAllPlaylists;
import controller.controllerMyProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class viewDashboard extends View {

	public AnchorPane rightCurrentAnchor;
	public AnchorPane centerCurrentAnchor;
	public JFXButton profileBtn;
	public JFXButton playlistsBtn;
	public JFXButton albumsBtn;
	public JFXButton listenersBtn;
	public JFXButton artistBtn;
	public JFXButton songsBtn;
	public JFXButton searchBtn;
	protected viewMusicPlayer musicPlayerView;
	protected PaneController currentPaneController;


	public viewDashboard (Stage primaryStage, Controller controller) {
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateDashboard.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);

		musicPlayerView = new viewMusicPlayer(rightCurrentAnchor);
	}

	public void changePane(ActionEvent actionEvent) {
		if (actionEvent.getSource() == searchBtn) {

		}
		else if (actionEvent.getSource() == songsBtn) {

		}
		else if (actionEvent.getSource() == artistBtn) {

		}
		else if (actionEvent.getSource() == listenersBtn) {

		}
		else if (actionEvent.getSource() == albumsBtn) {

		}
		else if (actionEvent.getSource() == playlistsBtn) {
			currentPaneController = new controllerAllPlaylists(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == profileBtn) {
			currentPaneController = new controllerMyProfile(centerCurrentAnchor);
		}
	}
}
