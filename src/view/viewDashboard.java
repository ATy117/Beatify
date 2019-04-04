package view;

import com.jfoenix.controls.JFXButton;
import controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

public abstract class viewDashboard extends View {

	private controllerDashboard controller;

	public AnchorPane rightCurrentAnchor;
	public AnchorPane centerCurrentAnchor;
	public JFXButton profileBtn;
	public JFXButton playlistsBtn;
	public JFXButton albumsBtn;
	public JFXButton listenersBtn;
	public JFXButton artistBtn;
	public JFXButton songsBtn;
	public JFXButton searchBtn;

	protected controllerMusicPlayer musicPlayer;
	protected PaneController currentPaneController;

	public viewDashboard (Stage primaryStage, controllerDashboard controller, ModelCentral model) {
		this.model = model;
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateDashboard.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);

		controller.setFoundationPane(centerCurrentAnchor);

		currentPaneController = new controllerAllSongs(centerCurrentAnchor, model, controller);
		controller.setCurrentPane(currentPaneController);

		musicPlayer = new controllerMusicPlayer(rightCurrentAnchor, model);
	}

	public void changePane(ActionEvent actionEvent) {

		if (actionEvent.getSource() == searchBtn) {
			currentPaneController = new controllerSearchResults(centerCurrentAnchor, model, controller);
		}
		else if (actionEvent.getSource() == songsBtn) {
			currentPaneController = new controllerAllSongs(centerCurrentAnchor, model, controller);
		}
		else if (actionEvent.getSource() == artistBtn) {
			currentPaneController = new controllerAllArtists(centerCurrentAnchor, model, controller);
		}
		else if (actionEvent.getSource() == listenersBtn) {
			currentPaneController = new controllerAllProfiles(centerCurrentAnchor, model, controller);
		}
		else if (actionEvent.getSource() == albumsBtn) {
			currentPaneController = new controllerAllAlbums(centerCurrentAnchor, model, controller);
		}
		else if (actionEvent.getSource() == playlistsBtn) {
			currentPaneController = new controllerAllPlaylists(centerCurrentAnchor, model, controller);
		}
		else if (actionEvent.getSource() == profileBtn) {
			currentPaneController = new controllerMyProfile(centerCurrentAnchor, model, controller);
		}

		controller.setCurrentPane(currentPaneController);
	}
}
