package controller;

import Facade.MasterFacade;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import object.Album;
import view.viewMusicPlayer;

public class controllerMusicPlayer extends Controller {

	private viewMusicPlayer musicPlayerView;

	public controllerMusicPlayer(AnchorPane playerPane, controllerDashboard controller) {
		this.model = controller.getModel();
		facade = MasterFacade.getInstance();
		musicPlayerView = new viewMusicPlayer(playerPane,this, controller);
		model.AttachToAll(musicPlayerView);
	}

	public Image getImageFromAlbum(int album_id) {
		return new Image("");
	}

	public Album getAlbumOfSong(int album_id) {
		return new Album();
	}

	public boolean playPrevSong(){
		if (model.getPlayerModel().playPreviousSong()) {
			return true;
		}
		return false;
	}

	public boolean playNextSong(){
		if (model.getPlayerModel().playNextSong()) {
			return true;
		}
		return false;
	}

	public void endPlayer() {
		musicPlayerView.endPlayer();
	}

	public boolean toggleShuffle() {
		if (model.getPlayerModel().isShuffled()) {
			System.out.println("shuffle is false");
			model.getPlayerModel().setShuffled(false);
			return false;
		}
		else {
			System.out.println("shuffle is true");
			model.getPlayerModel().setShuffled(true);
			return true;
		}
	}

	public boolean toggleRepeat() {
		if (model.getPlayerModel().isRepeating()) {
			System.out.println("repeat is false" );
			model.getPlayerModel().setRepeating(false);
			return false;
		}
		else {
			System.out.println("repeat is true");
			model.getPlayerModel().setRepeating(true);
			return true;
		}
	}

	public Image getImageOfAlbum (int album_id) {
		return facade.getImageOfAlbum(album_id);
	}
}
