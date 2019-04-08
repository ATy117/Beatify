package Facade;

import DAO.*;
import model.*;
import object.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MasterFacade {

	private static MasterFacade ourInstance;
	private AlbumDAO AD;
	private PlaylistDAO PD;
	private SongDAO SD;
	private UserDAO UD;

	private MasterFacade(){
		AD = new AlbumDAODB();
		PD = new PlaylistDAODB();
		SD = new SongDAODB();
		UD = new UserDAODB();
	}

	public static MasterFacade getInstance() {
		if (ourInstance == null) {
			ourInstance = new MasterFacade();
		}

		return ourInstance;
	}

	public void generateCacheFolder () {

		try {
			Files.createDirectories(Paths.get(System.getProperty("user.home") + "/documents/Beatify/"));
			Files.createDirectories(Paths.get(System.getProperty("user.home") + "/documents/Beatify/SongCache"));
			Files.createDirectories(Paths.get(System.getProperty("user.home") + "/documents/Beatify/PictureCache"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	// access the DAO to check if existing user, if wala pa, add a new user to DAO then return true, else return false
	public boolean register(String username, String password, String firstName, String lastName, boolean isArtist, File profilePic) {
		if (UD.checkUsername(username)){
			return false;
		} else {
			User user = new User();
			user.setAvatarURL(profilePic);
			user.setFirst_name(firstName);
			user.setLast_name(lastName);
			user.setUsername(username);
			user.setPassword(password);
			user.setIs_artist(isArtist);
			return UD.addUser(user);
		}
	}

	public boolean updateUser(User user){
		return UD.updateUser(user);
	}

	//  attempt to login using username and pass, if user is verified, return the user, else a null user will be returned
	public User loginUser (String username, String password) {
		return UD.getUser(username, password);
	}

	// keyword is entered, search all DAOS for results, then return the list of Searchables
	public List<Searchable> searchByKeyword (String keyword) {

		return null;
	}


	public List<User> searchUsers(String keyword, int user_id){
		List<User> userList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!UD.getAllUsers(keyword, user_id).isEmpty()){
			userList.addAll(UD.getAllUsers(keyword, user_id)); //if not empty, add all to userList
			return userList;
		}else{
			return userList; //returns an empty list
		}
	}

	public List<Song> searchSongs(String keyword, int artist_id){
		List<Song> songList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!SD.getAllSongs(keyword, artist_id).isEmpty()){
			songList.addAll(SD.getAllSongs(keyword, artist_id)); //if not empty, add all to songList
			return songList;
		}else {
			return songList; //returns an empty list
		}
	}

	public List<Album> searchAlbums(String keyword, int artist_id){
		List<Album> albumList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!AD.getAllAlbums(keyword, artist_id).isEmpty()){
			albumList.addAll(AD.getAllAlbums(keyword, artist_id)); //if not empty, add all to albumList
			return albumList;
		}else{
			return  albumList; //returns an empty list
		}
	}

	public List<Playlist> searchPlaylists(String keyword, int user_id){
		List<Playlist> playlistList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!PD.getAllPlaylists(keyword, user_id).isEmpty()){
			playlistList.addAll(PD.getAllPlaylists(keyword, user_id)); //if not empty, add all to playlistList
			return playlistList;
		}else{
			return playlistList; //returns an empty list
		}
	}

	// user likes song
	public boolean likeSong(int userid, int songid) {
		return SD.likeSong(songid, userid);
	}

	// user follows album
	public boolean followAlbum(int followersid, int albumid) {
		return AD.followAlbum(albumid, followersid);
	}

	// user follows playlist
	public boolean followPlaylist(int followersid, int playlistid) {
		return PD.followPlaylist(playlistid, followersid);
	}

	// user follows another user
	public boolean followUser(int followersid, int userid) {
		return UD.followerUser(userid, followersid);
	}

	// creates a new album, accesses DAO, returns false if duplicate (?) (album name unique for the same artist or no?)
	public boolean createAlbum (User user, Album album, File albumPic) {
		if(AD.checkAlbum(user.getUser_id(), album.getName())==-1) { //if checkAlbum returns -1, means there is no existing album like that
			AD.addAlbum(album);
			return true; //return true if added album successfully
		}else{
			return false;
		}
	}

	public boolean deleteAlbum(int albumID){
		return AD.deleteAlbum(albumID);
	}

	public boolean updateAlbum(Album album){
		return AD.updateAlbum(album);
	}

	// creates a playlist for user
	public boolean createPlaylist (User user, Playlist playlist) {
		PlaylistDAO playlistDAO = new PlaylistDAODB();
		if(playlistDAO.checkPlaylist(user.getUser_id(), playlist.getName())==-1){//if checkPlaylist returns -1, means there is no existing playlist like that
			playlistDAO.addPlaylist(playlist);
			return true; //return true if added playlist successfully
		}else {
			return false;
		}
	}

	public boolean deletePlaylist(int playlistID){
		return PD.deletePlaylist(playlistID);
	}

	public boolean updatePlaylist(Playlist playlist){
		return PD.updatePlaylist(playlist);
	}

	public List<Album> getMyAlbums(int user_id){
		return AD.getMyAlbums(user_id);
	}

	public List<Album> getFollowedAlbums(int user_id){
		return AD.getFollowedAlbums(user_id);
	}

	public List<Playlist> getMyPlaylists(int user_id){
		return PD.getMyPlaylists(user_id);
	}

	public List<Playlist> getFollowedPlaylists(int user_id){
		return PD.getFollowedPlaylists(user_id);
	}

	public List<Song> getMySongs(int user_id){
		return SD.getOwnerSongs(user_id);
	}

	public List<Song> getLikedSongs(int user_id){
		return SD.getLikedSongs(user_id);
	}

	public boolean addSong(Song song){
		if(SD.checkSong(song.getArtist__id(),song.getSong_name()) == -1)
			return SD.addSong(song);
		else return false;
	}

	public boolean deleteSong(int songID){
		return SD.deleteSong(songID);
	}

	public boolean updateSong(Song song){
		return SD.updateSong(song);
	}


}
