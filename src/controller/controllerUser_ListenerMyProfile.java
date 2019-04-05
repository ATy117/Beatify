package controller;

import javafx.scene.layout.AnchorPane;
import model.ModelCentral;
import view.viewSong_ArtistAllSongs;
import view.viewUser_ListenerMyProfile;

public class controllerUser_ListenerMyProfile extends Controller implements PaneController {

    public controllerUser_ListenerMyProfile(AnchorPane mainPane, ModelCentral model){
        this.model = model;
        currentPane = new viewUser_ListenerMyProfile(mainPane, model, this);
    }
}
