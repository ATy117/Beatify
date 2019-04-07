package Facade;

import DAO.*;
import model.*;
import object.*;

import java.io.File;
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

	}

	// user follows album
	public void followAlbum(int followersid, int albumid) {

	}

	// user follows playlist
	public void followPlaylist(int followersid, int playlistid) {

	}

	// user follows another user
	public void followUser(int followersid, int userid) {

	}

	// creates a new album, accesses DAO, returns false if duplicate (?) (album name unique for the same artist or no?)
	public boolean createAlbum (User user, Album album, File albumPic) {

		return false;
	}

	// creates a playlist for user
	public boolean createPlaylist (User user, Playlist playlist) {
		return false;
	}











}
