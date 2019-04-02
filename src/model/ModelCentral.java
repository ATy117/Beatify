package model;

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
}
