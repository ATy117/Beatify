package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import controller.controller_AddSong;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSearchables_ArtistAllSearchResults;
import view.Artist.viewSong_ArtistAlbumsOwnedSongs;
import view.Artist.viewSong_ArtistPlaylistsOwnedSongs;

public class controllerSong_ArtistAlbumsOwnedSongs extends PaneController  {

	public controllerSong_ArtistAlbumsOwnedSongs(AnchorPane mainPane, controllerDashboard dashboardController){
		super(mainPane, dashboardController);
		this.model = dashboardController.getModel();
		view = new viewSong_ArtistAlbumsOwnedSongs(mainPane,this, dashboardController);
	}

	public void deleteSong(Song song){
		facade.deleteSong(song.getSong_id());
		model.getLibraryModel().setSelectedAlbum(facade.getAlbum(song.getAlbum_id()));
		model.getLibraryModel().setSongContents(facade.getAlbumSongs(song.getAlbum_id()));
		controllerSong_ArtistAlbumsOwnedSongs c = new controllerSong_ArtistAlbumsOwnedSongs(dashboardController.getPaneFoundation(), dashboardController);
		dashboardController.setCurrentPane(c);
	}

	public void uploadSong() {
		PaneController upload = new controller_AddSong(dashboardController.getPaneFoundation(), dashboardController);
		dashboardController.setCurrentPane(upload);
	}

	public void playSong(Song song) {
		this.model.getPlayerModel().playSingleSong(song);
	}

	public void addSongToQueue(Song song) {
		this.model.getPlayerModel().addSongToQueue(song);
	}

	public boolean addSongToPlaylist(int song_id, int playlist_id) {
		return facade.addSongToPlaylist(song_id, playlist_id);
	}

	public void editSong(Song song) {
		this.model.getLibraryModel().setSelectedSong(song);
	}
}
