package view;

import com.jfoenix.controls.JFXButton;
import controller.*;
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
	protected controllerMusicPlayer musicPlayer;
	protected PaneController currentPaneController;


	public viewDashboard (Stage primaryStage, Controller controller) {
		this.primaryStage = primaryStage;
		this.controller = controller;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("templateDashboard.fxml"));
		loader.setController(this);

		sm = new StageManager(primaryStage);
		sm.loadScene(loader);

		musicPlayer = new controllerMusicPlayer(rightCurrentAnchor);
	}

	public void changePane(ActionEvent actionEvent) {
		if (actionEvent.getSource() == searchBtn) {
			currentPaneController = new controllerSearchResults(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == songsBtn) {
			currentPaneController = new controllerAllSongs(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == artistBtn) {
			currentPaneController = new controllerAllArtists(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == listenersBtn) {
			currentPaneController = new controllerAllProfiles(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == albumsBtn) {
			currentPaneController = new controllerAllAlbums(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == playlistsBtn) {
			currentPaneController = new controllerAllPlaylists(centerCurrentAnchor);
		}
		else if (actionEvent.getSource() == profileBtn) {
			currentPaneController = new controllerMyProfile(centerCurrentAnchor);
		}
	}
}
