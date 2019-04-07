package model;

import object.Album;
import object.Playlist;
import object.Song;
import object.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchModel extends Model {
    private List<Song> songResults = new ArrayList<>();
    private List<Album> albumResults = new ArrayList<>();
    private List<Playlist> playlistResults = new ArrayList<>();
    private List<User> artistResults = new ArrayList<>();
    private List<User> listenerResults = new ArrayList<>();

    public Iterator<Song> getSongResults() {
        return songResults.iterator();
    }

    public Iterator<Album> getAlbumResults() {
        return albumResults.iterator();
    }

    public Iterator<Playlist> getPlaylistResults() {
        return playlistResults.iterator();
    }

    public Iterator<User> getArtistResults() {
        return artistResults.iterator();
    }

    public Iterator<User> getListenerResults() {
        return listenerResults.iterator();
    }

    public void setSongResults(List<Song> songResults) {
        this.songResults = songResults;
        Notify();
    }

    public void setAlbumResults(List<Album> albumResults) {
        this.albumResults = albumResults;
        Notify();
    }

    public void setPlaylistResults(List<Playlist> playlistResults) {
        this.playlistResults = playlistResults;
        Notify();
    }

    public void setArtistResults(List<User> artistResults) {
        this.artistResults = artistResults;
        Notify();
    }

    public void setListenerResults(List<User> listenerResults) {
        this.listenerResults = listenerResults;
        Notify();
    }
}
