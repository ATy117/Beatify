package DAO;

import object.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAODB implements UserDAO{
    Connection connection = null;

    @Override
    public boolean addUser(User user) {
        String usernameTemp = user.getUsername();
        String passwordTemp = user.getPassword();
        String firstNameTemp = user.getFirst_name();
        String lastNameTemp = user.getLast_name();
        int isArtistTemp = (user.isIs_artist()) ? 1:0;
        FileInputStream avatarStream = null;
        try {
            avatarStream = new FileInputStream(user.getAvatarURL());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO user VALUES(NULL,?,?,?,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstNameTemp);
            statement.setString(2, lastNameTemp);
            statement.setString(3, usernameTemp);
            statement.setString(4, passwordTemp);
            statement.setInt(5, isArtistTemp);
            statement.setBinaryStream(6, avatarStream);

            statement.executeUpdate();
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int user_id) {
        String query = "DELETE FROM user WHERE user.user_id = " + user_id;

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUser(String username, String password) {
        return null;
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public List<User> getFollowers(User user) {
        return null;
    }
}
