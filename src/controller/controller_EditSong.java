package controller;

import controller.Artist.controllerAlbum_ArtistAllAlbums;
import javafx.scene.layout.AnchorPane;
import object.Album;
import object.User;
import view.view_AddAlbum;
import view.view_EditSong;

import java.io.File;
import java.time.LocalDate;

public class controller_EditSong extends PaneController {
    public controller_EditSong(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new view_EditSong(mainPane, this, dashboardController);

    }

}
