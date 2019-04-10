package Facade;

import CacheManager.CacheManager;
import DAO.*;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
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
	private NotificationDAO ND;
	private CacheManager cacheManager;

	private MasterFacade(){
		AD = new AlbumDAODB();
		PD = new PlaylistDAODB();
		SD = new SongDAODB();
		UD = new UserDAODB();
		ND = new NotificationDAODB();
		cacheManager = new CacheManager();
	}

	public static MasterFacade getInstance() {
		if (ourInstance == null) {
			ourInstance = new MasterFacade();
		}

		return ourInstance;
	}

	public void generateCacheFolder () {
		cacheManager.generateCacheFolder();
		System.out.println("Cache folder is existing / created");
	}

	public Album getAlbum(int album_id){
		return AD.getAlbum(album_id);
	}

	public Playlist getPlaylist(int playlist_id){
		return PD.getPlaylist(playlist_id);
	}

	public User viewUser(int user_id){
		return UD.getProfile(user_id);
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


	public List<User> searchListeners(String keyword, int user_id){
		List<User> userList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!UD.searchListeners(keyword, user_id).isEmpty()){
			userList.addAll(UD.searchListeners(keyword, user_id)); //if not empty, add all to userList
			return userList;
		}else{
			return userList; //returns an empty list
		}
	}

	public List<User> searchArtists(String keyword, int user_id){
		List<User> userList = new ArrayList<>();
		//check if list retrived from dao is empty
		if(!UD.searchArtists(keyword, user_id).isEmpty()){
			userList.addAll(UD.searchArtists(keyword, user_id)); //if not empty, add all to userList
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

	public boolean unlikeSong(int userid, int songid){
		return SD.unlikeSong(songid,userid);
	}

	// user follows album
	public boolean followAlbum(int followersid, int albumid) {
		return AD.followAlbum(albumid, followersid);
	}

	public boolean unfollowAlbum(int followersid, int albumid){
		return AD.unfollowAlbum(albumid,followersid);
	}
	// user follows playlist
	public boolean followPlaylist(int followersid, int playlistid) {
		return PD.followPlaylist(playlistid, followersid);
	}

	public boolean unfollowPlaylist(int followersid, int playlistid){
		return PD.unfollowPlaylist(playlistid,followersid);
	}

	// user follows another user
	public boolean followUser(int followersid, int userid) {
		return UD.followerUser(userid, followersid);
	}

	public boolean unfollowUser(int followersid, int userid){
		return UD.unfollowerUser(userid,followersid);
	}
	// creates a new album, accesses DAO, returns false if duplicate (?) (album name unique for the same artist or no?)
	public boolean createAlbum (User user, Album album) {
		if(AD.checkAlbum(user.getUser_id(), album.getName())==-1) { //if checkAlbum returns -1, means there is no existing album like that
			AD.addAlbum(album);
			createNotification(album.getArtist_name() + " has created an album: " + album.getName(), user.getUser_id());
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
			createNotification(user.getFirst_name() + " " + user.getLast_name() + " has created a playlist: " + playlist.getName(), user.getUser_id());
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

	public List<User> getFollowedArtists(int user_id){
		return UD.getFollowedArtists(user_id);
	}

	public List<User> getFollowedListeners(int user_id){
		return UD.getFollowedListeners(user_id);
	}


	public boolean uploadSong(Song song){
		if(SD.checkSong(song.getArtist__id(),song.getSong_name()) == -1) {
			createNotification(song.getArtist_name() + " has added a new song: " + song.getSong_name(), song.getArtist__id());
			SD.addSong(song);
			int song_id = SD.checkSong(song.getArtist__id(), song.getSong_name());
			addSongToAlbum(song_id,song.getAlbum_id());
			return true;
		}
		else return false;
	}

	public boolean deleteSong(int songID){
		return SD.deleteSong(songID);
	}

	public boolean updateSong(Song song){
		return SD.updateSong(song);
	}

	public boolean addSongToPlaylist(int songid, int playlistid){
		return SD.addSongToPlaylist(songid,playlistid);
	}

	public boolean deleteSongFromPlaylist(int song_id, int playlist_id){
		return SD.deleteSongFromPlaylist(song_id, playlist_id);
	}

	public boolean addSongToAlbum(int songid, int albumid){
		return SD.addSongToAlbum(songid,albumid);
	}

	public List<Song> getPlaylistSongs(int playlist_id){
		return SD.getPlaylistSongs(playlist_id);
	}
	public List<Song> getAlbumSongs(int album_id){
		return SD.getAlbumSongs(album_id);
	}

	public void createNotification(String notification, int userID){
		if(ND.addNotification(notification,userID)){
		    int notificationID = ND.getNotifID(notification, userID);
			ArrayList<Integer> followerIDs = new ArrayList<>();
			for (User user: UD.getFollowers(userID))
				followerIDs.add(user.getUser_id());
			for (Integer followerID: followerIDs)
			    ND.addToNotifMapping(notificationID,followerID);
		}
	}

	public List<Notification> getUnviewedNotifications(int userID){
		return ND.getUnviewedNotifications(userID);
	}

	public List<Notification> getAllNotifications(int userID){
		return ND.getAllNotifications(userID);
	}

	public boolean removeNotif(int user_id, int notif_id){
		return ND.deleteNotifMapping(notif_id, user_id);
	}

	public boolean setNotificationAsViewed(int notif_id, int user_id){
		return ND.viewNotification(notif_id,user_id);
	}

	public Image getImageOfAlbum(int album_id) {
		Image pic;

		if (album_id == -1) {
			pic = new Image("/resources/Logo.png");
		}
		else {
			Album selected = AD.getAlbum(album_id);
			pic = new Image(selected.getCover_URL().toURI().toString());
		}

		return pic;
	}

	public Media getSongFile(int song_id) {

		File file = SD.getSongFile(song_id);
		return new Media(file.toURI().toString());
	}
}
