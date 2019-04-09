package view.Artist;

import controller.Artist.*;
import controller.Listener.*;
import controller.controllerDashboard;
import controller.controllerSong_MyQueue;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import view.viewDashboard;

public class viewArtistDashboard extends viewDashboard {

	public viewArtistDashboard (Stage primaryStage, controllerDashboard controller) {
		super(primaryStage, controller);
		sm.setWindowName("Beatify for Artist");
	}

	public void changePane(ActionEvent actionEvent) {

		if (actionEvent.getSource() == searchBtn) {
			currentPaneController = new controllerSearchables_ArtistAllSearchResults(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == songsBtn) {
			currentPaneController = new controllerSong_ArtistAllSongs(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == artistBtn) {
			currentPaneController = new controllerArtist_ArtistFollowedArtists(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == listenersBtn) {
			currentPaneController = new controllerListener_ArtistFollowedListeners(centerCurrentAnchor,controller);
		}
		else if (actionEvent.getSource() == albumsBtn) {
			currentPaneController = new controllerAlbum_ArtistAllAlbums(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == playlistsBtn) {
			currentPaneController = new controllerPlaylist_ArtistsAllPlaylists(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == profileBtn) {
			currentPaneController = new controllerUser_ArtistMyProfile(centerCurrentAnchor, controller, primaryStage);
		}
		else if (actionEvent.getSource() == queueBtn) {
			currentPaneController = new controllerSong_MyQueue(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == notificationsBtn){
			currentPaneController = new controllerNotifs_ArtistNotifications(centerCurrentAnchor, controller);
		}

		controller.setCurrentPane(currentPaneController);
	}

	@Override
	public void Update() {
		
	}
}
