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
}
