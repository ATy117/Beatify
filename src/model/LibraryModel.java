package model;

import object.Album;
import object.Playlist;
import object.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryModel extends Model {
    private List<Album> myAlbums = new ArrayList<>();
    private List<Album> followedAlbums = new ArrayList<>();
    private List<Playlist> myPlaylists = new ArrayList<>();
    private List<Playlist> followedPlaylists = new ArrayList<>();
    private List<Song> allSongs = new ArrayList<>();
    private List<Song> songContents = new ArrayList<>();

    public Iterator<Album> getMyAlbums() {
        return myAlbums.iterator();
    }

    public Iterator<Album> getFollowedAlbums() {
        return followedAlbums.iterator();
    }

    public Iterator<Playlist> getMyPlaylists() {
        return myPlaylists.iterator();
    }

    public Iterator<Playlist> getFollowedPlaylists() {
        return followedPlaylists.iterator();
    }

    public Iterator<Song> getAllSongs() {
        return allSongs.iterator();
    }

    public Iterator<Song> getSongContents() {
        return songContents.iterator();
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

    public void setSongContents(List<Song> songContents) {
        this.songContents = songContents;
        Notify();
    }
}
