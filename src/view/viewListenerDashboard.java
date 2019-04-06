package view;

import com.jfoenix.controls.JFXButton;
import controller.Controller;
import controller.controllerDashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ModelCentral;

import java.io.IOException;

public class viewListenerDashboard extends viewDashboard {

	public viewListenerDashboard (Stage primaryStage, controllerDashboard controller) {
		super(primaryStage, controller);
		sm.setWindowName("Beatify");
	}

	public void changePane(ActionEvent actionEvent) {

		/*
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

		 */
	}

	@Override
	public void Update() {

	}
}
