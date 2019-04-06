package controller;

import Facade.MasterFacade;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import object.Album;
import view.viewMusicPlayer;

public class controllerMusicPlayer extends Controller {

	public controllerMusicPlayer(AnchorPane playerPane, controllerDashboard controller) {
		this.model = controller.getModel();
		facade = MasterFacade.getInstance();
		viewMusicPlayer musicPlayerView = new viewMusicPlayer(playerPane,this, controller);
		model.AttachToAll(musicPlayerView);
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
