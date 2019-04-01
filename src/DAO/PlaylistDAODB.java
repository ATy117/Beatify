package DAO;

import object.Playlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PlaylistDAODB implements PlaylistDAO {
    Connection connection = null;

    @Override
    public boolean addPlaylist(Playlist playlist) {
        String playlistNameTemp = playlist.getName();
        int isPublicTemp = (playlist.isIs_public()) ? 1:0;
        int userIdTemp = playlist.getUser_id();

        String query = "INSERT INTO playlist VALUES(NULL,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, playlistNameTemp);
            statement.setInt(2, isPublicTemp);
            statement.setInt(3, userIdTemp);

            statement.executeUpdate();
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlaylist(int playlist_id) {
        String query = "DELETE FROM playlist WHERE playlist.playlist_id = " + playlist_id;

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
    public boolean updatePlaylist(Playlist playlist) {
        return false;
    }

    @Override
    public int checkPlaylist(int user_id, String playlist_name) {
        return 0;
    }

    @Override
    public Playlist getPlaylist(int playlist_id) {
        return null;
    }

    @Override
    public List<Playlist> getMyPlaylists(int user_id) {
        return null;
    }

    @Override
    public List<Playlist> getFollowedPlaylists(int user_id) {
        return null;
    }
}
