package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
import object.Album;
import object.User;
import view.view_AddAlbum;
import view.view_AddSong;

import java.io.File;
import java.time.LocalDate;

public class controller_AddSong extends PaneController {
    public controller_AddSong(AnchorPane mainPane, controllerDashboard dashboardController){
        super(dashboardController);
        this.model = dashboardController.getModel();
        view = new view_AddSong(mainPane, this, dashboardController);

    }


}
