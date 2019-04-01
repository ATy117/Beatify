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
}
