package controller;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import object.Album;

public class controllerMusicPlayer extends Controller {

	public controllerMusicPlayer(AnchorPane playerPane, ModelCentral model) {
		this.model = model;
		viewMusicPlayer musicPlayerView = new viewMusicPlayer(playerPane, model, this);
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
