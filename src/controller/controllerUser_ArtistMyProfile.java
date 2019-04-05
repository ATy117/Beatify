package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_ArtistAllSongs;
import view.viewUser_ArtistMyProfile;

public class controllerUser_ArtistMyProfile extends Controller implements PaneController {

    public controllerUser_ArtistMyProfile(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewUser_ArtistMyProfile(mainPane, model, this);
    }
}
