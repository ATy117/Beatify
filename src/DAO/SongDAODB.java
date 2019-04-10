package DAO;

import object.Song;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SongDAODB implements SongDAO {
    Connection connection = dbConnection.getInstance();

    @Override
    public boolean addSong(Song song) {
        int songID = song.getSong_id();
        String titleTemp = song.getSong_name();
        String genreTemp = song.getGenre();
        LocalDate dateUploadedTemp = song.getDate_uploaded();
        String dateTemp = dateUploadedTemp.toString();
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
            statement.executeUpdate();
            statement.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
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
    public boolean updateSong(Song song) {
        int songID = song.getSong_id();
        String titleTemp = song.getSong_name();
        String genreTemp = song.getGenre();
        LocalDate dateUploadedTemp = song.getDate_uploaded();
        String dateTemp = dateUploadedTemp.toString();
        int artistIDTemp = song.getArtist__id();

        String query = "UPDATE song SET " +
                        "song.title = ?, " +
                        "song.genre = ?, " +
                        "song.date_uploaded = ?, " +
                        "song.artist_id = ? WHERE song.song_id = " + songID;
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, titleTemp);
            statement.setString(2, genreTemp);
            statement.setString(3, dateTemp);
            statement.setInt(4, artistIDTemp);
            statement.executeUpdate();
            statement.close();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
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
            statement.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return song;
    }

    @Override
    public List<Song> getOwnerSongs(int user_id) {
        String query = "SELECT song.song_id, song.title, song.genre, song.date_uploaded, song.artist_id, user.user_id, user.first_name, user.last_name, album.album_id, album.name\n" +
                "FROM song INNER JOIN user ON song.artist_id = user.user_id \n" +
                "INNER JOIN album_contents ON album_contents.song_id = song.song_id \n" +
                "INNER JOIN album ON album_contents.album_id = album.album_id\n" +
                "WHERE song.artist_id = " + user_id;
        List<Song> songList = new ArrayList<>();

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                songList.add(toSong(rs));
            }
            statement.close();
            rs.close();
            return songList;
        }catch(SQLException e){
            e.printStackTrace();
            return songList;
        }catch (IOException e){
            e.printStackTrace();
            return songList;
        }
    }

    @Override
    public List<Song> getPlaylistSongs(int playlist_id) {
        List<Song> songList = new ArrayList<>();

        String query =  "SELECT song.song_id, song.title, song.genre, song.date_uploaded, song.artist_id, user.user_id, user.first_name, user.last_name, album.album_id, album.name\n" +
                "FROM song \n" +
                "INNER JOIN user ON song.artist_id = user.user_id \n" +
                "INNER JOIN album_contents ON album_contents.song_id = song.song_id \n" +
                "INNER JOIN album ON album_contents.album_id = album.album_id\n" +
                "INNER JOIN playlist_contents ON playlist_contents.song_id = song.song_id\n" +
                "WHERE playlist_contents.playlist_id = " + playlist_id;

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                songList.add(toSong(rs));
            }
            statement.close();
            rs.close();
            return songList;
        }catch(SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public List<Song> getAlbumSongs(int album_id) {
        List<Song> songList = new ArrayList<>();

        String query =  "SELECT song.song_id, song.title, song.genre, song.date_uploaded, song.artist_id, user.user_id, user.first_name, user.last_name, album.album_id, album.name\n" +
                "FROM song \n" +
                "INNER JOIN user ON song.artist_id = user.user_id \n" +
                "INNER JOIN album_contents ON album_contents.song_id = song.song_id \n" +
                "INNER JOIN album ON album_contents.album_id = album.album_id\n" +
                "WHERE album.album_id = " + album_id;

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                songList.add(toSong(rs));
            }
            statement.close();
            rs.close();
            return songList;
        }catch(SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public List<Song> getLikedSongs(int user_id) {
        List<Song> songList = new ArrayList<>();

        String query =  "SELECT song.song_id, song.title, song.genre, song.date_uploaded, song.artist_id, user.user_id, user.first_name, user.last_name, album.album_id, album.name\n" +
                "FROM song \n" +
                "INNER JOIN user ON song.artist_id = user.user_id \n" +
                "INNER JOIN album_contents ON album_contents.song_id = song.song_id \n" +
                "INNER JOIN album ON album_contents.album_id = album.album_id\n" +
                "INNER JOIN liked_mapping ON liked_mapping.song_id = song.song_id\n" +
                "WHERE liked_mapping.user_id = " + user_id;

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                songList.add(toSong(rs));
            }
            statement.close();
            rs.close();
            return songList;
        }catch(SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public int checkSong(int user_id, String song_name) {
        String query = 	"SELECT song.song_id FROM song WHERE song.artist_id = '"+user_id+"' AND song.title = '"+song_name+"'";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int songID = rs.getInt("song.song_id");
                return songID;
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
    public boolean checkSongPlaylist(int song_id, int playlist_id) {
        String query = 	"SELECT playlist_contents.song_id FROM playlist_contents WHERE playlist_contents.song_id = '"+song_id+"' AND playlist_contents.playlist_id = '"+playlist_id+"'";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                rs.close();
                statement.close();
                return true;
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
    public boolean likeSong(int song_id, int user_id) {
        String query = "INSERT INTO liked_mapping VALUES(?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, user_id);
            statement.setInt(2, song_id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean unlikeSong(int song_id, int user_id) {
        String query = "DELETE FROM liked_mapping WHERE liked_mapping.user_id = ? AND liked_mapping.song_id = ?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, user_id);
            statement.setInt(2, song_id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public File getSongFile(int song_id) {
        String query = "SELECT song.title, song.file, user.first_name, user.last_name " +
                "FROM song INNER JOIN user ON song.artist_id = user.user_id " +
                "WHERE song.song_id = " + song_id;
        File songFile = null;

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                songFile = toFile(rs);
                statement.close();
                rs.close();
                return songFile;
            }
        }catch(SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songFile;
    }

    @Override
    public List<Song> getAllSongs(String keyword, int artist_id) {
        String query = "SELECT song.song_id, song.title, song.genre, song.date_uploaded, song.artist_id, user.user_id, user.first_name, user.last_name, album.album_id, album.name\n" +
                "FROM song INNER JOIN user ON song.artist_id = user.user_id \n" +
                "INNER JOIN album_contents ON album_contents.song_id = song.song_id \n" +
                "INNER JOIN album ON album_contents.album_id = album.album_id\n" +
                "WHERE song.title LIKE ? AND song.artist_id != ?";
        List<Song> songList = new ArrayList<>();
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            statement.setInt(2, artist_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                songList.add(toSong(rs));
            }
            statement.close();
            rs.close();
            return songList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songList;
    }

    private Song toSong(ResultSet rs) throws SQLException, IOException {
        Song song = new Song();
        song.setSong_id(rs.getInt("song.song_id"));
        song.setSong_name(rs.getString("song.title"));
        song.setGenre(rs.getString("song.genre"));
        String date = rs.getString("song.date_uploaded");
        LocalDate localDate = LocalDate.parse(date);
        song.setDate_uploaded(localDate);
        song.setAlbum_id(rs.getInt("album.album_id"));
        song.setAlbum_name(rs.getString("album.name"));
        song.setArtist__id(rs.getInt("user.user_id"));
        song.setArtist_name(rs.getString("user.first_name") + " " + rs.getString("user.last_name"));

        return song;
    }

    private File toFile(ResultSet rs) throws SQLException, IOException {
        File file = new File(System.getProperty("user.home") + "/documents/Beatify/SongCache/" + rs.getString("song.title")+"-"+rs.getString("user.first_name") + " " + rs.getString("user.last_name")+".mp3");
        OutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = rs.getBinaryStream("song.file");
        byte[] buffer = new byte[4096];
        while (inputStream.read(buffer) > 0){
            outputStream.write(buffer);
        }
        return file;
    }
}
