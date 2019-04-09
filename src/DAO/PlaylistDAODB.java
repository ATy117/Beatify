package DAO;

import object.Album;
import object.Playlist;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAODB implements PlaylistDAO {
    Connection connection = dbConnection.getInstance();

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
        int playlistID = playlist.getPlaylist_id();
        String playlistNameTemp = playlist.getName();
        int isPublicTemp = (playlist.isIs_public()) ? 1:0;
        int userIdTemp = playlist.getUser_id();

        String query = "UPDATE playlist SET " +
                "playlist.name = ?, " +
                "playlist.is_public = ?, " +
                "playlist.user_id = ? WHERE playlist.playlist_id = " +playlistID;

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
    public int checkPlaylist(int user_id, String playlist_name) {
        String query = 	"SELECT playlist.playlist_id FROM playlist WHERE playlist.user_id = '"+user_id+"' AND playlist.name = '"+playlist_name+"'";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int playlistID = rs.getInt("playlist.playlist_id");
                return playlistID;
            }

            rs.close();
            statement.close();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Playlist getPlaylist(int playlist_id) {
        Playlist playlist = new Playlist();
        String query = "SELECT playlist.playlist_id, playlist.name, playlist.is_public, playlist.user_id, user.first_name, user.last_name FROM playlist INNER JOIN user \n" +
                "ON playlist.user_id = user.user_id WHERE playlist.playlist_id = " +playlist_id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                playlist = toPlaylist(rs);
            }
            rs.close();
            statement.close();
            return playlist;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Playlist> getMyPlaylists(int user_id) {
        List<Playlist> playlists = new ArrayList<>();
        Playlist playlist = new Playlist();
        String query = "SELECT playlist.playlist_id, playlist.name, playlist.is_public, playlist.user_id, user.first_name, user.last_name FROM playlist INNER JOIN user \n" +
                "ON playlist.user_id = user.user_id WHERE playlist.user_id = " +user_id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                playlists.add(toPlaylist(rs));
            }
            rs.close();
            statement.close();
            return playlists;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return playlists;
    }

    @Override
    public List<Playlist> getFollowedPlaylists(int user_id) {
        List<Playlist> playlists = new ArrayList<>();
        String query = "SELECT followed_playlist.playlist_id FROM playlist INNER JOIN followed_playlist\n" +
                "ON playlist.playlist_id = followed_playlist.playlist_id\n" +
                "WHERE followed_playlist.follower_id = " + user_id;

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs= statement.executeQuery();
            while(rs.next()){
                Playlist playlist = getPlaylist(rs.getInt("followed_playlist.playlist_id"));
                playlists.add(playlist);
            }
            statement.close();
            rs.close();
            return playlists;
        }catch (SQLException e){
            e.printStackTrace();
            return playlists;
        }
    }

    @Override
    public boolean followPlaylist(int playlist_id, int follower_id) {
        String query = "INSERT INTO followed_playlist VALUES(?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, playlist_id);
            statement.setInt(2, follower_id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean unfollowPlaylist(int playlist_id, int follower_id) {
        String query = "DELETE FROM followed_playlist WHERE followed_playlist.playlist_id = ? AND followed_playlist.follower_id = ?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, playlist_id);
            statement.setInt(2, follower_id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Playlist> getAllPlaylists(String keyword, int user_id) {
        String query = "SELECT playlist.playlist_id, playlist.name, playlist.is_public, playlist.user_id, user.first_name, user.last_name FROM playlist INNER JOIN user \n" +
                "ON playlist.user_id = user.user_id WHERE playlist.name LIKE ? AND playlist.user_id != ? AND playlist.is_public = 1";
        List<Playlist> playlistList = new ArrayList<>();
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            statement.setInt(2, user_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                playlistList.add(toPlaylist(rs));
            }
            statement.close();
            rs.close();
            return playlistList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playlistList;
    }

    private Playlist toPlaylist(ResultSet rs) throws SQLException, IOException {
        Playlist playlist = new Playlist();

        playlist.setPlaylist_id(rs.getInt("playlist.playlist_id"));
        playlist.setName(rs.getString("playlist.name"));
        playlist.setIs_public(rs.getInt("playlist.is_public")!=0);
        playlist.setUser_id(rs.getInt("playlist.user_id"));
        playlist.setOwner_name(rs.getString("user.first_name") + " " + rs.getString("user.last_name"));
        return playlist;
    }
}
