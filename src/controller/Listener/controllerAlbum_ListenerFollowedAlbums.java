package controller.Listener;

import controller.Artist.controllerSong_ArtistAlbumsFollowedSongs;
import controller.Artist.controllerSong_ArtistAlbumsOwnedSongs;
import controller.PaneController;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
import controller.controller_EditAlbum;
import javafx.scene.layout.AnchorPane;
import object.Album;
import view.Listener.viewAlbum_ListenerFollowedAlbums;

public class controllerAlbum_ListenerFollowedAlbums extends PaneController {

    public controllerAlbum_ListenerFollowedAlbums(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getLibraryModel().setFollowedAlbums(facade.getFollowedAlbums(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewAlbum_ListenerFollowedAlbums(mainPane, this, dashboardController);
    }

    public void goToFollowedList(int album_id){
        model.getLibraryModel().setSelectedAlbum(facade.getAlbum(album_id));
        model.getLibraryModel().setSongContents(facade.getAlbumSongs(album_id));
        controllerSong_ArtistAlbumsFollowedSongs c = new controllerSong_ArtistAlbumsFollowedSongs(mainPane, dashboardController);
        dashboardController.setCurrentPane(c);
    }

    public void unfollowAlbum(int album_id){
        facade.unfollowAlbum(model.getProfileModel().getUser().getUser_id(), album_id);
        model.getLibraryModel().setFollowedAlbums(facade.getFollowedAlbums(this.model.getProfileModel().getUser().getUser_id()));
    }


}
