package DAO;

import object.User;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAODB implements UserDAO{
    Connection connection = dbConnection.getInstance();

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
        int userID = user.getUser_id();
        String firstNameTemp = user.getFirst_name();
        String lastNameTemp = user.getLast_name();
        String usernameTemp = user.getUsername();
        String passwordTemp = user.getPassword();
        int isArtistTemp = (user.isIs_artist()) ? 1:0;
        FileInputStream avatarStream = null;
        try {
            avatarStream = new FileInputStream(user.getAvatarURL());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String query = "UPDATE user SET " +
                "user.first_name = ?, " +
                "user.last_name = ?, " +
                "user.username = ?, " +
                "user.password = ?, " +
                "user.is_artist = ?, " +
                "user.avatar = ? WHERE user.user_id = " + userID;

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
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String username, String password) {
        User user = new User();
        String query = "SELECT * FROM user";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                String dbUsername = rs.getString("user.username");
                String dbPassword = rs.getString("user.password");
                if(dbUsername.equals(username) && dbPassword.equals(password)){
                    try {
                        user = toUser(rs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    rs.close();
                    statement.close();
                    return user;
                }
            }

            rs.close();
            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkUsername(String username) {
        String query = 	"SELECT user.username FROM user";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                String usernameTemp = rs.getString("user.username");
                if(usernameTemp.equals(username)){
                    return true;
                }

            }

            rs.close();
            statement.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getFollowers(User user) {
        String query = "SELECT user.user_id, user.username, user.first_name, user.last_name, user.password, user.is_artist, user.avatar FROM user INNER JOIN follower_mapping\n" +
                "ON user.user_id = follower_mapping.follower_id\n" +
                "WHERE follower_mapping.user_id = " + user.getUser_id();

        List<User> userList = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs= statement.executeQuery();
            while(rs.next()){
                userList.add(toUser(rs));
            }

            return userList;
        }catch (SQLException e){
            e.printStackTrace();
            return userList;
        } catch (IOException e) {
            e.printStackTrace();
            return userList;
        }

    }

    private User toUser(ResultSet rs) throws SQLException, IOException {
        User user = new User();

        user.setUser_id(rs.getInt("user.user_id"));
        user.setFirst_name(rs.getString("user.first_name"));
        user.setLast_name(rs.getString("user.last_name"));
        user.setUsername(rs.getString("user.username"));
        user.setUsername(rs.getString("user.password"));
        user.setIs_artist((rs.getInt("user.is_artist")!=0));
       // user.setAvatarURL(toFile(rs));

        return user;
    }

    private File toFile(ResultSet rs) throws SQLException, IOException {
        File file = new File("src/resources/" + rs.getString("user.username")+"_avatar.png");
        OutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = rs.getBinaryStream("user.avatar");
        byte[] buffer = new byte[4096];
        while (inputStream.read(buffer) > 0){
            outputStream.write(buffer);
        }
        return file;
    }
}
