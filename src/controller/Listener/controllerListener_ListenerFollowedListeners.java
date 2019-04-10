package controller.Listener;

import controller.Artist.controllerUser_ArtistShowListenerProfile;
import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewListener_ListenerFollowedListeners;

public class controllerListener_ListenerFollowedListeners extends PaneController {

    public controllerListener_ListenerFollowedListeners(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        this.model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(this.model.getProfileModel().getUser().getUser_id()));
        view = new viewListener_ListenerFollowedListeners(mainPane, this, dashboardController);
    }

    public void unfollow(int unfollowed_id){
        int user_id = model.getProfileModel().getUser().getUser_id();
        facade.unfollowUser(user_id, unfollowed_id);
        model.getProfileModel().setFollowedListeners(facade.getFollowedListeners(user_id));
    }

    public void checkProfile(int user_id){
        model.getPeopleModel().setSelectedUser(facade.viewUser(user_id));
        model.getPeopleModel().setAlbums(facade.getMyAlbums(user_id));
        model.getPeopleModel().setPlaylists(facade.getPublicPlaylists(user_id));
        controllerUser_ArtistShowListenerProfile controller = new controllerUser_ArtistShowListenerProfile(mainPane, dashboardController);
        dashboardController.setCurrentPane(controller);
    }
}
