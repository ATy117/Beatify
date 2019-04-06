package controller;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import object.Album;
import view.viewMusicPlayer;

public class controllerMusicPlayer extends Controller {

	public controllerMusicPlayer(AnchorPane playerPane, controllerDashboard controller) {
		this.model = controller.getModel();
		viewMusicPlayer musicPlayerView = new viewMusicPlayer(playerPane,this, controller);
	}

	public Image getImageFromAlbum(int album_id) {
		return new Image("");
	}

	public Album getAlbumOfSong(int album_id) {
		return new Album();
	}

	public void playPrevSong() {
	}

	public void playNextSong() {
	}

	public boolean toggleShuffle() {
		return true;
	}

	public boolean toggleRepeat() {
		return false;
	}
}
