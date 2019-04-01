package DAO;

import object.User;

import java.util.List;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean deleteUser(int user_id);
	public void updateUser(User user);
	public User getUser(String username, String password);
	public boolean checkUsername(String username);
	public List<User> getFollowers(User user);
}
