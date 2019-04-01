package DAO;

import object.Song;

import java.io.File;
import java.util.List;

public interface SongDAO {

	public boolean addSong (Song song);
	public boolean addSongToPlaylist (int song_id, int playlist_id);
	public boolean addSongToAlbum(int song_id, int album_id);

	public boolean deleteSong (int song_id);
	public boolean deleteSongFromPlaylist (int song_id, int playlist_id);

	public void updateSong (Song song);

	public Song getSong(int song_id);
	public List<Song> getAllSongs(int user_id);
	public List<Song> getPlaylistSongs(int user_id, int playlist_id);
	public List<Song> getAlbumSongs(int user_id, int album_id);
	public List<Song> getLikedSongs(int user_id);

	public int checkSong(int user_id, String song_name);
	public boolean checkSongPlaylist(int song_id, int playlist_id);

	public File getSongFile (int song_id);
}
