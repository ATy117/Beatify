package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import controller.controller_AddAlbum;
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
        controllerSong_ArtistAlbumsFollowedSongs c = new controllerSong_ArtistAlbumsFollowedSongs(dashboardController.getPaneFoundation(), dashboardController);
        dashboardController.setCurrentPane(this);
    }

    public void goToOwnList(int album_id){
        model.getLibraryModel().setSelectedAlbum(facade.getAlbum(album_id));
        model.getLibraryModel().setSongContents(facade.getAlbumSongs(album_id));
        controllerSong_ArtistAlbumsOwnedSongs c = new controllerSong_ArtistAlbumsOwnedSongs(dashboardController.getPaneFoundation(), dashboardController);
        dashboardController.setCurrentPane(this);
    }

    public void uploadAlbum(){
        controller_AddAlbum controlleAddAlbums = new controller_AddAlbum(dashboardController.getPaneFoundation(), dashboardController);
        dashboardController.setCurrentPane(this);
    }
}
