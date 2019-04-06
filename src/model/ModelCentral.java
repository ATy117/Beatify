package model;

import view.View;

public class ModelCentral {
    private static ModelCentral ourInstance;
    private LibraryModel libraryModel;
    private ProfileModel profileModel;
    private SongPlayerModel playerModel;
    private OtherPeopleModel peopleModel;

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

    public void resetModels(){
        libraryModel = null;
        profileModel = null;
        playerModel = null;
        peopleModel = null;
    }

    public void AttachToAll(View currentPane) {
        libraryModel.Attach(currentPane);
        profileModel.Attach(currentPane);
        playerModel.Attach(currentPane);
        peopleModel.Attach(currentPane);
    }

    public void DetachToAll(View currentPane) {
        libraryModel.Detach(currentPane);
        profileModel.Detach(currentPane);
        playerModel.Detach(currentPane);
        peopleModel.Detach(currentPane);
    }
}
