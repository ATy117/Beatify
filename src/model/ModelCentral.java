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
    }

    public void AttachToAll(View view) {
        libraryModel.Attach(view);
        profileModel.Attach(view);
        playerModel.Attach(view);
        peopleModel.Attach(view);
    }

    public void DetachToAll(View view) {
        libraryModel.Detach(view);
        profileModel.Detach(view);
        playerModel.Detach(view);
        peopleModel.Detach(view);
    }
}
