package object;

import java.io.File;
import java.time.LocalDate;

public class Album implements Searchable{
    private int album_id;
    private String name;
    private File cover_URL;
    private LocalDate date_uploaded;
    private int artist_id;
    private String artist_name;

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getCover_URL() {
        return cover_URL;
    }

    public void setCover_URL(File cover_URL) {
        this.cover_URL = cover_URL;
    }

    public LocalDate getDate_uploaded() {
        return date_uploaded;
    }

    public void setDate_uploaded(LocalDate date_uploaded) {
        this.date_uploaded = date_uploaded;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }
}
