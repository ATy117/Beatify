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

	private MasterFacade(){}

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
		UserDAO UD = new UserDAODB();
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


	//  attempt to login using username and pass, if user is verified, return the user, else a null user will be returned
	public User loginUser (String username, String password) {
		UserDAO UD = new UserDAODB();
		return UD.getUser(username, password);
	}

	// keyword is entered, search all DAOS for results, then return the list of Searchables
	public List<Searchable> searchByKeyword (String keyword) {

		return null;
	}


	public List<User> searchUsers(String keyword, int user_id){
		UserDAO userDAO = new UserDAODB();
		List<User> userList = new ArrayList<>();

		//check if list retrived from dao is empty
		if(!userDAO.getAllUsers(keyword, user_id).isEmpty()){
			userList.addAll(userDAO.getAllUsers(keyword, user_id)); //if not empty, add all to userList
			return userList;
		}else{
			return userList; //returns an empty list
		}
	}

	public List<Song> searchSongs(String keyword, int artist_id){
		SongDAO songDAO = new SongDAODB();
		List<Song> songList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!songDAO.getAllSongs(keyword, artist_id).isEmpty()){
			songList.addAll(songDAO.getAllSongs(keyword, artist_id)); //if not empty, add all to songList
			return songList;
		}else {
			return songList; //returns an empty list
		}
	}

	public List<Album> searchAlbums(String keyword, int artist_id){
		AlbumDAO albumDAO = new AlbumDAODB();
		List<Album> albumList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!albumDAO.getAllAlbums(keyword, artist_id).isEmpty()){
			albumList.addAll(albumDAO.getAllAlbums(keyword, artist_id)); //if not empty, add all to albumList
			return albumList;
		}else{
			return  albumList; //returns an empty list
		}
	}

	public List<Playlist> searchPlaylists(String keyword, int user_id){
		PlaylistDAO playlistDAO = new PlaylistDAODB();
		List<Playlist> playlistList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!playlistDAO.getAllPlaylists(keyword, user_id).isEmpty()){
			playlistList.addAll(playlistDAO.getAllPlaylists(keyword, user_id)); //if not empty, add all to playlistList
			return playlistList;
		}else{
			return playlistList; //returns an empty list
		}
	}

	// user likes song
	public void likeSong(int userid, int songid) {
		SongDAO songDAO = new SongDAODB();
		songDAO.likeSong(songid, userid);
	}

	// user follows album
	public void followAlbum(int followersid, int albumid) {
		AlbumDAO albumDAO = new AlbumDAODB();
		albumDAO.followAlbum(albumid, followersid);
	}

	// user follows playlist
	public void followPlaylist(int followersid, int playlistid) {
		PlaylistDAO playlistDAO = new PlaylistDAODB();
		playlistDAO.followPlaylist(playlistid, followersid);
	}

	// user follows another user
	public void followUser(int followersid, int userid) {
		UserDAO userDAO = new UserDAODB();
		userDAO.followerUser(userid, followersid);
	}

	// creates a new album, accesses DAO, returns false if duplicate (?) (album name unique for the same artist or no?)
	public boolean createAlbum (User user, Album album, File albumPic) {
		AlbumDAO albumDAO = new AlbumDAODB();
		if(albumDAO.checkAlbum(user.getUser_id(), album.getName())==-1) { //if checkAlbum returns -1, means there is no existing album like that
			albumDAO.addAlbum(album);
			return true; //return true if added album successfully
		}else{
			return false;
		}
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

	public List<Album> getMyAlbums(int user_id){
		AlbumDAO AD = new AlbumDAODB();
		return AD.getMyAlbums(user_id);
	}

	public List<Album> getFollowedAlbums(int user_id){
		AlbumDAO AD = new AlbumDAODB();
		return AD.getFollowedAlbums(user_id);
	}

	public List<Playlist> getMyPlaylists(int user_id){
		PlaylistDAO PD = new PlaylistDAODB();
		return PD.getMyPlaylists(user_id);
	}

	public List<Playlist> getFollowedPlaylists(int user_id){
		PlaylistDAO PD = new PlaylistDAODB();
		return PD.getFollowedPlaylists(user_id);
	}

	public List<Song> getMySongs(int user_id){
		SongDAO SD = new SongDAODB();
		return SD.getOwnerSongs(user_id);
	}

	public List<Song> getLikedSongs(int user_id){
		SongDAO SD = new SongDAODB();
		return SD.getLikedSongs(user_id);
	}














}
