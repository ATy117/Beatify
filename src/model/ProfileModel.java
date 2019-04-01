package model;

import object.User;

import java.util.ArrayList;
import java.util.List;

public class ProfileModel extends Model {
    private User user = null;
    private List<User> followedUsers = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public List<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setUser(User user) {
        this.user = user;
        Notify();
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.followedUsers = followedUsers;
        Notify();
    }
}
