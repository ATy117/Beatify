package model;

import object.Album;
import object.Playlist;
import object.Song;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel extends Model {
    private List<Album> myAlbums = new ArrayList<>();
    private List<Album> followedAlbums = new ArrayList<>();
    private List<Playlist> myPlaylists = new ArrayList<>();
    private List<Playlist> followedPlaylists = new ArrayList<>();
    private List<Song> allSongs = new ArrayList<>();

    public List<Album> getMyAlbums() {
        return myAlbums;
    }

    public List<Album> getFollowedAlbums() {
        return followedAlbums;
    }

    public List<Playlist> getMyPlaylists() {
        return myPlaylists;
    }

    public List<Playlist> getFollowedPlaylists() {
        return followedPlaylists;
    }

    public List<Song> getAllSongs() {
        return allSongs;
    }

    public void setMyAlbums(List<Album> myAlbums) {
        this.myAlbums = myAlbums;
        Notify();
    }

    public void setFollowedAlbums(List<Album> followedAlbums) {
        this.followedAlbums = followedAlbums;
        Notify();
    }

    public void setMyPlaylists(List<Playlist> myPlaylists) {
        this.myPlaylists = myPlaylists;
        Notify();
    }

    public void setFollowedPlaylists(List<Playlist> followedPlaylists) {
        this.followedPlaylists = followedPlaylists;
        Notify();
    }

    public void setAllSongs(List<Song> allSongs) {
        this.allSongs = allSongs;
        Notify();
    }
}
