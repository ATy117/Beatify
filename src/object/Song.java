package object;

import java.io.File;
import java.time.LocalDate;

public class Song implements Searchable {
    private int song_id;
    private String song_name;

    private String genre;

    private LocalDate date_uploaded;

    private int album_id;
    private String album_name;

    private String artist_name;
    private int artist__id;

    private File song_URL;

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDate_uploaded() {
        return date_uploaded;
    }

    public void setDate_uploaded(LocalDate date_uploaded) {
        this.date_uploaded = date_uploaded;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getArtist__id() {
        return artist__id;
    }

    public void setArtist__id(int artist__id) {
        this.artist__id = artist__id;
    }

    public File getSong_URL() {
        return song_URL;
    }

    public void setSong_URL(File song_URL) {
        this.song_URL = song_URL;
    }
}
