package DAO;

import object.Album;

import java.util.List;

public interface AlbumDAO {
	public boolean addAlbum(Album album);
	public boolean deleteAlbum(int album_id);
	public void updateAlbum(Album album);
	public Album getAlbum(int album_id);
	public List<Album> getMyAlbums(int user_id);
	public int checkAlbum(int user_id, String album_name);
	public List<Album> getFollowedAlbums(int user_id);
}
