package controller.Artist;

import controller.*;
import javafx.scene.layout.AnchorPane;
import object.Album;
import view.Artist.viewAlbum_ArtistAllAlbums;

public class controllerAlbum_ArtistAllAlbums extends PaneController {

    public controllerAlbum_ArtistAllAlbums(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setMyAlbums(facade.getMyAlbums(this.model.getProfileModel().getUser().getUser_id()));
        this.model.getLibraryModel().setFollowedAlbums(facade.getFollowedAlbums(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewAlbum_ArtistAllAlbums(mainPane, this, dashboardController);
    }

    public void goToFollowedList(int album_id){
        model.getLibraryModel().setSelectedAlbum(facade.getAlbum(album_id));
        model.getLibraryModel().setSongContents(facade.getAlbumSongs(album_id));
        controllerSong_ArtistAlbumsFollowedSongs c = new controllerSong_ArtistAlbumsFollowedSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public void goToOwnList(int album_id){
        model.getLibraryModel().setSelectedAlbum(facade.getAlbum(album_id));
        model.getLibraryModel().setSongContents(facade.getAlbumSongs(album_id));
        controllerSong_ArtistAlbumsOwnedSongs c = new controllerSong_ArtistAlbumsOwnedSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public boolean deleteAlbum(int album_id){
        if (facade.getAlbumSongs(album_id).size() != 0){
            return false;
        } else {
            facade.deleteAlbum(album_id);
            model.getLibraryModel().setMyAlbums(facade.getMyAlbums(this.model.getProfileModel().getUser().getUser_id()));
            return true;
        }
    }

    public void unfollowAlbum(int album_id){
        facade.unfollowAlbum(model.getProfileModel().getUser().getUser_id(), album_id);
        model.getLibraryModel().setFollowedAlbums(facade.getFollowedAlbums(this.model.getProfileModel().getUser().getUser_id()));
    }

    public void uploadAlbum(){
        controller_AddAlbum controllerAddAlbums = new controller_AddAlbum(mainPane, dashboardController);
        dashboardController.setCurrentPane(controllerAddAlbums);
    }

	public void editAlbum(Album album) {
        this.model.getLibraryModel().setSelectedAlbum(album);
        controller_EditAlbum edit = new controller_EditAlbum(mainPane, dashboardController);
        dashboardController.setCurrentPane(edit);
	}
}
