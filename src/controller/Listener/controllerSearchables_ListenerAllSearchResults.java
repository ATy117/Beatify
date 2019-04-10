package controller.Listener;

import controller.PaneController;
import controller.controllerDashboard;
import javafx.scene.layout.AnchorPane;
import view.Listener.viewSearchables_ListenerAllSearchResults;

public class controllerSearchables_ListenerAllSearchResults extends PaneController {

    public controllerSearchables_ListenerAllSearchResults(AnchorPane mainPane, controllerDashboard dashboardController){
        super(mainPane, dashboardController);
        this.model = dashboardController.getModel();
        view = new viewSearchables_ListenerAllSearchResults(mainPane, this, dashboardController);
    }
    public void search(String query){
        int user_id = model.getProfileModel().getUser().getUser_id();
        this.model.getSearchModel().setSongResults(facade.searchSongs(query, user_id));
        this.model.getSearchModel().setAlbumResults(facade.searchAlbums(query, user_id));
        this.model.getSearchModel().setPlaylistResults(facade.searchPlaylists(query, user_id));
        this.model.getSearchModel().setArtistResults(facade.searchArtists(query, user_id));
        this.model.getSearchModel().setListenerResults(facade.searchListeners(query, user_id));
    }
}
