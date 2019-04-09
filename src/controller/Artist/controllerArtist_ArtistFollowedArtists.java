package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewArtist_ArtistFollowedArtists;

public class controllerArtist_ArtistFollowedArtists extends PaneController {

    public controllerArtist_ArtistFollowedArtists(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedArtists(facade.getFollowedArtists(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewArtist_ArtistFollowedArtists(mainPane, this, dashboardController);
    }

    public void unfollow(int unfollowed_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.unfollowUser(user_id, unfollowed_id);
        model.getProfileModel().setFollowedArtists(facade.getFollowedArtists(user_id));
    }
}
