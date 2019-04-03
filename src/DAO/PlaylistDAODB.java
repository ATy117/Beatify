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
        String query = "SELECT * FROM playlist WHERE playlist.playlist_id = " +playlist_id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                try {
                    playlist = toPlaylist(rs);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                rs.close();
                statement.close();
                return playlist;
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
    public List<Playlist> getMyPlaylists(int user_id) {
        List<Playlist> playlists = new ArrayList<>();
        Playlist playlist = new Playlist();
        String query = "SELECT * FROM playlist WHERE playlist.user_id = " +user_id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                try {
                    playlist = toPlaylist(rs);
                    playlists.add(playlist);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                rs.close();
                statement.close();
            }
            rs.close();
            statement.close();
            return playlists;
        } catch (SQLException e) {
            e.printStackTrace();
            playlists.clear();
            return playlists;
        }
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

            return playlists;
        }catch (SQLException e){
            e.printStackTrace();
            return playlists;
        }
    }

    private Playlist toPlaylist(ResultSet rs) throws SQLException, IOException {
        Playlist playlist = new Playlist();

        playlist.setPlaylist_id(rs.getInt("playlist.playlist_id"));
        playlist.setName(rs.getString("playlist.name"));
        playlist.setIs_public(rs.getInt("playlist.is_public")!=0);
        playlist.setUser_id(rs.getInt("playlist.user_id"));

        return playlist;
    }
}
