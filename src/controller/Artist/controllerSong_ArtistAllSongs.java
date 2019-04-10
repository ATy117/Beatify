package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import object.Song;
import view.Artist.viewSong_ArtistAllSongs;

public class controllerSong_ArtistAllSongs extends PaneController {

    public controllerSong_ArtistAllSongs(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setAllSongs(facade.getMySongs(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewSong_ArtistAllSongs(mainPane, this, dashboardController);
    }

    public boolean addSongToPlaylist (int song_id, int playlist_id){
        return facade.addSongToPlaylist(song_id, playlist_id);
    }

	public void addSongToQueue(Song song) {
		this.model.getPlayerModel().addSongToQueue(song);
	}
}
