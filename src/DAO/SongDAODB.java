package DAO;

import object.Song;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class SongDAODB implements SongDAO {
    Connection connection = null;

    @Override
    public boolean addSong(Song song) {
        int songID = song.getSong_id();
        String titleTemp = song.getSong_name();
        String genreTemp = song.getGenre();
        LocalDate dateUploadedTemp = song.getDate_uploaded();
        String dateTemp = dateUploadedTemp.getYear()+"-"+dateUploadedTemp.getMonthValue()+"-"+dateUploadedTemp.getDayOfMonth();
        int artistIDTemp = song.getArtist__id();
        FileInputStream songFileStream = null;
        try {
            songFileStream = new FileInputStream(song.getSong_URL());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO song VALUES(NULL,?,?,?,?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, titleTemp);
            statement.setString(2, genreTemp);
            statement.setString(3,dateTemp);
            statement.setInt(4, artistIDTemp);
            statement.setBinaryStream(5, songFileStream);
            statement.executeUpdate();
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSongToPlaylist(int song_id, int playlist_id) {
        return false;
    }

    @Override
    public boolean addSongToAlbum(int song_id, int album_id) {
        return false;
    }

    @Override
    public boolean deleteSong(int song_id) {
        return false;
    }

    @Override
    public boolean deleteSongFromPlaylist(int song_id, int playlist_id) {
        return false;
    }

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public Song getSong(int song_id) {
        return null;
    }

    @Override
    public List<Song> getAllSongs(int user_id) {
        return null;
    }

    @Override
    public List<Song> getPlaylistSongs(int user_id, int playlist_id) {
        return null;
    }

    @Override
    public List<Song> getAlbumSongs(int user_id, int album_id) {
        return null;
    }

    @Override
    public List<Song> getLikedSongs(int user_id) {
        return null;
    }

    @Override
    public int checkSong(int user_id, String song_name) {
        return 0;
    }

    @Override
    public boolean checkSongPlaylist(int song_id, int playlist_id) {
        return false;
    }

    @Override
    public File getSongFile(int song_id) {
        return null;
    }
}
