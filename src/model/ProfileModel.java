package model;

import object.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfileModel extends Model {
    private User user = null;
    private List<User> followedArtists = new ArrayList<>();
    private List<User> followedListeners = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public Iterator<User> getFollowedArtists() {
        return followedArtists.iterator();
    }

    public Iterator<User> getFollowedListeners() {
        return followedListeners.iterator();
    }

    public void setUser(User user) {
        this.user = user;
        Notify();
    }

    public void setFollowedArtists(List<User> followedArtists) {
        this.followedArtists = followedArtists;
        Notify();
    }

    public void setFollowedListeners(List<User> followedListeners) {
        this.followedListeners = followedListeners;
        Notify();
    }
}
