package model;

import object.Song;

import java.util.ArrayList;
import java.util.List;

public class SongPlayerModel extends Model {
    private Song currentSong = null;
    private List<Song> currentList = new ArrayList<>();
    private List<Song> finishedList = new ArrayList<>();
    private boolean repeating = false;
    private boolean shuffled = false;

    public Song getCurrentSong() {
        return currentSong;
    }

    public List<Song> getCurrentList() {
        return currentList;
    }

    public List<Song> getFinishedList() {
        return finishedList;
    }

    public boolean isRepeating() {
        return repeating;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setCurrentSong(Song currentSong) {
        this.currentSong = currentSong;
    }

    public void setCurrentList(List<Song> currentList) {
        this.currentList = currentList;
    }

    public void setFinishedList(List<Song> finishedList) {
        this.finishedList = finishedList;
    }

    public void setRepeating(boolean repeating) {
        this.repeating = repeating;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }
}
