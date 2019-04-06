package DAO;

import object.Album;
import object.User;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAODB implements AlbumDAO{
    Connection connection = dbConnection.getInstance();

    @Override
    public boolean addAlbum(Album album) {
        String nameTemp = album.getName();
        LocalDate dateUploadedTemp = album.getDate_uploaded();
        String date = dateUploadedTemp.toString();
        int artistIdTemp = album.getArtist_id();
        FileInputStream coverStream = null;
        try {
            coverStream = new FileInputStream(album.getCover_URL());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO album VALUES(NULL,?,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nameTemp);
            statement.setString(2, date);
            statement.setInt(3, artistIdTemp);
            statement.setBinaryStream(4, coverStream);

            statement.executeUpdate();
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAlbum(int album_id) {
        String query = "DELETE FROM album WHERE album.album_id = " + album_id;

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
    public boolean updateAlbum(Album album) {
        int albumID = album.getAlbum_id();
        String nameTemp = album.getName();
        LocalDate dateUploadedTemp = album.getDate_uploaded();
        String date = dateUploadedTemp.toString();
        int artistIdTemp = album.getArtist_id();
        FileInputStream coverStream = null;
        try {
            coverStream = new FileInputStream(album.getCover_URL());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String query = "UPDATE album SET " +
                "album.name = ?, " +
                "album.date_created = ?, " +
                "album.artist_id = ?, " +
                "album.album_cover = ? WHERE album.album_id = " + albumID;

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nameTemp);
            statement.setString(2, date);
            statement.setInt(3, artistIdTemp);
            statement.setBinaryStream(4, coverStream);

            statement.executeUpdate();
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Album getAlbum(int album_id) {
        Album album = new Album();
        String query = "SELECT album.album_id, album.name, album.date_created, album.artist_id, album.album_cover, user.first_name, user.last_name FROM album INNER JOIN user\n" +
                "ON album.artist_id = user.user_id WHERE album.album_id = " +album_id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                try {
                    album = toAlbum(rs);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                rs.close();
                statement.close();
                return album;
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
    public List<Album> getMyAlbums(int user_id) {
        List<Album> albums = new ArrayList<>();
        Album album = new Album();
        String query = "SELECT album.album_id, album.name, album.date_created, album.artist_id, album.album_cover, user.first_name, user.last_name FROM album INNER JOIN user\n" +
                "ON album.artist_id = user.user_id WHERE album.artist_id = " +user_id;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                try {
                    album = toAlbum(rs);
                    albums.add(album);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                rs.close();
                statement.close();
            }
            rs.close();
            statement.close();
            return albums;
        } catch (SQLException e) {
            e.printStackTrace();
            albums.clear();
            return albums;
        }
    }

    @Override
    public int checkAlbum(int user_id, String album_name) { //returns the album id
        String query = 	"SELECT album.album_id FROM album WHERE album.artist_id = '"+user_id+"' AND album.name = '"+album_name+"'";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int albumID = rs.getInt("album.album_id");
                return albumID;
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
    public List<Album> getFollowedAlbums(int user_id) {
        List<Album> albumList = new ArrayList<>();
        String query = "SELECT followed_album.album_id FROM album INNER JOIN followed_album\n" +
                "ON album.album_id = followed_album.album_id\n" +
                "WHERE followed_album.follower_id = " + user_id;

        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs= statement.executeQuery();
            while(rs.next()){
                Album album = getAlbum(rs.getInt("followed_album.album_id"));
                albumList.add(album);
            }

            return albumList;
        }catch (SQLException e){
            e.printStackTrace();
            return albumList;
        }
    }

    @Override
    public boolean followAlbum(int album_id, int follower_id) {
        String query = "INSERT INTO followed_album VALUES(?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, album_id);
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
    public boolean unfollowAlbum(int album_id, int follower_id) {
        String query = "DELETE FROM album_id WHERE followed_album.album_id = ? AND followed_album.follower_id = ?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, album_id);
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
    public List<Album> getAllAlbums(String keyword) {
        String query = "SELECT album.album_id, album.name, album.date_created, album.artist_id, album.album_cover, user.first_name, user.last_name FROM album INNER JOIN user\n" +
                "ON album.artist_id = user.user_id WHERE album.name LIKE ?";
        List<Album> albumList = new ArrayList<>();

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                albumList.add(toAlbum(rs));
            }
            return albumList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return albumList;
    }

    private Album toAlbum(ResultSet rs) throws SQLException, IOException {
        Album album = new Album();

        album.setAlbum_id(rs.getInt("album.album_id"));
        album.setName(rs.getString("album.name"));
        String date = rs.getString("album.date_created");
        LocalDate localDate = LocalDate.parse(date);
        album.setDate_uploaded(localDate);
        album.setArtist_id(rs.getInt("album.artist_id"));
        album.setArtist_name(rs.getString("user.first_name")+ " " + rs.getString("user.last_name"));
        album.setCover_URL(toFile(rs));

        return album;
    }

    private File toFile(ResultSet rs) throws SQLException, IOException {
        File file = new File("src/resources/" + rs.getString("album.name")+"_cover.png");
        OutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = rs.getBinaryStream("album.album_cover");
        byte[] buffer = new byte[4096];
        while (inputStream.read(buffer) > 0){
            outputStream.write(buffer);
        }
        return file;
    }
}
