package DAO;

import object.Album;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AlbumDAODB implements AlbumDAO{
    Connection connection = null;

    @Override
    public boolean addAlbum(Album album) {
        String nameTemp = album.getName();
        LocalDate dateUploadedTemp = album.getDate_uploaded();
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
            statement.setString(2, dateUploadedTemp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
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
    public void updateAlbum(Album album) {

    }

    @Override
    public Album getAlbum(int album_id) {
        return null;
    }

    @Override
    public List<Album> getMyAlbums(int user_id) {
        return null;
    }

    @Override
    public int checkAlbum(int user_id, String album_name) {
        return 0;
    }

    @Override
    public List<Album> getFollowedAlbums(int user_id) {
        return null;
    }
}
