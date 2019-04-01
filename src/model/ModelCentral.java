package model;

public class ModelCentral {
    private static ModelCentral ourInstance = new ModelCentral();
    private LibraryModel libraryModel;
    private ProfileModel profileModel;
    private SongPlayerModel playerModel;

    public static ModelCentral getInstance() {
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

    public void setLibraryModel(LibraryModel libraryModel) {
        this.libraryModel = libraryModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public void setPlayerModel(SongPlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public void resetModels(){
        libraryModel = null;
        profileModel = null;
        playerModel = null;
    }
}
