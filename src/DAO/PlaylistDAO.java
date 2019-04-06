package DAO;

import object.Playlist;

import java.util.List;

public interface PlaylistDAO {
	public boolean addPlaylist(Playlist playlist);
	public boolean deletePlaylist(int playlist_id);
	public boolean updatePlaylist(Playlist playlist);
	public int checkPlaylist(int user_id, String playlist_name);
	public Playlist getPlaylist(int playlist_id);
	public List<Playlist> getMyPlaylists(int user_id);
	public List<Playlist> getFollowedPlaylists(int user_id);
	public boolean followPlaylist(int playlist_id, int follower_id);
	public boolean unfollowPlaylist(int playlist_id, int follower_id);
	public List<Playlist> getAllPlaylists(String keyword);
}