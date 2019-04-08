package model;

import view.View;

public class ModelCentral {
    private static ModelCentral ourInstance;
    private LibraryModel libraryModel;
    private ProfileModel profileModel;
    private SongPlayerModel playerModel;
    private OtherPeopleModel peopleModel;
    private SearchModel searchModel;
    private NotificationModel notificationModel;

    public static ModelCentral getInstance() {

        if (ourInstance == null) {
            ourInstance = new ModelCentral();
        }
        return ourInstance;
    }

    private ModelCentral() {
    }

    public LibraryModel getLibraryModel() {
        return libraryModel;
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public SongPlayerModel getPlayerModel() {
        return playerModel;
    }

    public OtherPeopleModel getPeopleModel() {
        return peopleModel;
    }

    public SearchModel getSearchModel() {
        return searchModel;
    }

    public NotificationModel getNotificationModel() {
        return notificationModel;
    }

    public void setLibraryModel(LibraryModel libraryModel) {
        this.libraryModel = libraryModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public void setPlayerModel(SongPlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public void setPeopleModel(OtherPeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }

    public void setSearchModel(SearchModel searchModel) {
        this.searchModel = searchModel;
    }

    public void setNotificationModel(NotificationModel notificationModel) {
        this.notificationModel = notificationModel;
    }

    public void resetModels(){
        libraryModel = null;
        profileModel = null;
        playerModel = null;
        peopleModel = null;
        searchModel = null;
        notificationModel = null;
    }

    public void AttachToAll(View currentPane) {
        libraryModel.Attach(currentPane);
        profileModel.Attach(currentPane);
        playerModel.Attach(currentPane);
        peopleModel.Attach(currentPane);
        searchModel.Attach(currentPane);
        notificationModel.Attach(currentPane);
    }

    public void DetachToAll(View currentPane) {
        libraryModel.Detach(currentPane);
        profileModel.Detach(currentPane);
        playerModel.Detach(currentPane);
        peopleModel.Detach(currentPane);
        searchModel.Detach(currentPane);
        notificationModel.Detach(currentPane);
    }

    public void clearViews () {
        libraryModel.getViews().clear();
        profileModel.getViews().clear();
        playerModel.getViews().clear();
        peopleModel.getViews().clear();
        searchModel.getViews().clear();
        notificationModel.getViews().clear();

        System.out.println("Cleared all views");
    }


}
