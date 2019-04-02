package model;

import object.Album;
import object.Playlist;
import object.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OtherPeopleModel extends Model {
    private List<Album> albums = new ArrayList<>();
    private List<Playlist> playlists = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();

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
