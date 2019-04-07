package DAO;

import object.User;

import java.util.List;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean deleteUser(int user_id);
	public boolean updateUser(User user);
	public User getUser(String username, String password);
	public boolean checkUsername(String username);
	public List<User> getFollowers(int user_id);
	public List<User> getFollowedListeners(int user_id);
	public List<User> getFollowedArtists(int user_id);
	public boolean followerUser(int user_id, int follower_id);
	public boolean unfollowerUser(int user_id, int follower_id);
	public List<User> getAllUsers(String keyword, int user_id);
}
