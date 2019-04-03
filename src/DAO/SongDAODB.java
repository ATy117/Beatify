package DAO;

import object.Song;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String query = "INSERT INTO playlist_contents VALUES(?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, playlist_id);
            statement.setInt(2, song_id);
            statement.executeUpdate();
            statement.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSongToAlbum(int song_id, int album_id) {
        String query = "INSERT INTO album_contents VALUES(?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, album_id);
            statement.setInt(2, song_id);
            statement.executeUpdate();
            statement.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSong(int song_id) {
        String query = "DELETE FROM song WHERE song.song_id = " + song_id;

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.executeQuery();
            statement.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public boolean deleteSongFromPlaylist(int song_id, int playlist_id) {
        String query = "DELETE FROM playlist_contents WHERE playlist_contents.playlist_id = ? AND playlist_contents.song_id = ?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, playlist_id);
            statement.setInt(2, song_id);
            statement.executeUpdate();
            statement.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateSong(Song song) {
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

        String query = "UPDATE song + SET " +
                        "song.title = ?, " +
                        "song.genre = ?, " +
                        "song.date_uploaded = ?, " +
                        "song.artist_id = ?, " +
                        "song.file = ? WHERE song.song_id = " + songID;
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, titleTemp);
            statement.setString(2, genreTemp);
            statement.setString(3, dateTemp);
            statement.setInt(4, artistIDTemp);
            statement.setBinaryStream(5, songFileStream);
            statement.executeUpdate();
            statement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Song getSong(int song_id){
        String query = "SELECT song.song_id, song.title, song.genre, song.date_uploaded, song.artist_id, song.file, user.user_id, user.first_name, user.last_name, album.album_id, album.name " +
        "FROM song INNER JOIN user ON song.artist_id = user.user_id " +
        "INNER JOIN album_contents ON album_contents.song_id = song.song_id " +
        "INNER JOIN album ON album_contents.album_id = album.album_id " +
        "WHERE song.song_id = " + song_id;
        Song song = null;

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                song = toSong(rs);
                return song;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return song;
        } catch (IOException e) {
            e.printStackTrace();
            return song;
        }
        return song;
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

    private Song toSong(ResultSet rs) throws SQLException, IOException {
        Song song = new Song();
        song.setSong_id(rs.getInt("song.song_id"));
        song.setSong_name(rs.getString("song.title"));
        song.setGenre(rs.getString("song.genre"));
        LocalDate date = LocalDate.parse(rs.getString("song.date_uploaded"));
        song.setDate_uploaded(date);
        song.setAlbum_id(rs.getInt("album_contents.album_id"));
        song.setAlbum_name(rs.getString("album.name"));
        song.setArtist__id(rs.getInt("user.user_id"));
        song.setArtist_name(rs.getString("user.first_name") + " " + rs.getString("user.last_name"));
        song.setSong_URL(toFile(rs));

        return song;
    }

    private File toFile(ResultSet rs) throws SQLException, IOException {
        File file = new File("src/resources/" + rs.getString("song.title")+"-"+rs.getString("user.first_name") + " " + rs.getString("user.last_name")+".mp3");
        OutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = rs.getBinaryStream("song.file");
        byte[] buffer = new byte[4096];
        while (inputStream.read(buffer) > 0){
            outputStream.write(buffer);
        }
        return file;
    }
}
