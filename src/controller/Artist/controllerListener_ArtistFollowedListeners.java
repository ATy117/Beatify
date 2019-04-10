package controller.Artist;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Artist.viewListener_ArtistFollowedListeners;

public class controllerListener_ArtistFollowedListeners extends PaneController {

    public controllerListener_ArtistFollowedListeners(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewListener_ArtistFollowedListeners(mainPane, this, dashboardController);
    }

    public void unfollow(int unfollowed_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.unfollowUser(user_id, unfollowed_id);
        model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(user_id));
    }
}
