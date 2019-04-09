package model;

import object.Album;
import object.Playlist;
import object.Song;
import object.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OtherPeopleModel extends Model {
    private List<Album> albums = new ArrayList<>();
    private List<Playlist> playlists = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();
    private Album selectedAlbum;
    private Playlist selectedPlaylist;
    private User selectedUser;

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Album getSelectedAlbum() {
        return selectedAlbum;
    }

    public void setSelectedAlbum(Album selectedAlbum) {
        this.selectedAlbum = selectedAlbum;
    }

    public Playlist getSelectedPlaylist() {
        return selectedPlaylist;
    }

    public void setSelectedPlaylist(Playlist selectedPlaylist) {
        this.selectedPlaylist = selectedPlaylist;
    }

    public Iterator<Album> getAlbums() {
        return albums.iterator();
    }

    public Iterator<Playlist> getPlaylists() {
        return playlists.iterator();
    }

    public Iterator<Song> getSongs() {
        return songs.iterator();
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
        Notify();
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
        Notify();
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        Notify();
    }
}
