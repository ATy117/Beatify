package DAO;

import object.Song;

import java.io.File;
import java.sql.Connection;
import java.util.List;

public class SongDAODB implements SongDAO {
    Connection connection = null;

    @Override
    public boolean addSong(Song song) {
        return false;
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
