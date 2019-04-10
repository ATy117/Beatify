package model;

import object.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongPlayerModel extends Model {
    private Song currentSong = null;
    private List<Song> currentList = new ArrayList<>();
    private List<Song> finishedList = new ArrayList<>();
    private boolean repeating = false;
    private boolean shuffled = false;


    public void playSongFromList(List<Song> currentList) {
        this.currentList = new ArrayList<>(currentList);
        finishedList = new ArrayList<>();
        currentSong = this.currentList.get(0);
        this.currentList.remove(0);
        Notify();
    }

    public void playSingleSong(Song song) {
        currentSong = song;
        Notify();
    }

    public boolean playNextSong() {

        if (currentList.isEmpty() && repeating) {
            repeatFinishedSongs();
        }

        if (!currentList.isEmpty()) {
            finishedList.add(currentSong);
            if(!shuffled) {
                currentSong = currentList.get(0);
                currentList.remove(0);
            }
            else {
                int randomindex = getRandonIndexInCurList();
                currentSong = currentList.get(randomindex);
                currentList.remove(randomindex);
            }
        }
        else {
            return false;
        }
        Notify();

        return true;

    }


    public void addPlaylistToQueue (List<Song> playlist) {
        currentList.addAll(playlist);

        if (currentSong == null) {
            currentSong = this.currentList.get(0);
            this.currentList.remove(0);
            Notify();
        }


    }

    public void addSongToQueue(Song s) {
        currentList.add(s);
        System.out.println("added " + s.getSong_name() + "to queue");

        if (currentSong == null) {
            currentSong = this.currentList.get(0);
            this.currentList.remove(0);
            Notify();
        }

    }


    public boolean playPreviousSong() {

        if (!finishedList.isEmpty()) {
            currentList.add(0, currentSong);
            currentSong = finishedList.get(finishedList.size()-1);
            finishedList.remove(finishedList.size()-1);
        }

        Notify();

        return true;
    }


    private void repeatFinishedSongs () {
        currentList = new ArrayList<>(finishedList);
        finishedList.clear();
    }


    private int getRandonIndexInCurList() {

        ArrayList randompool = new ArrayList();
        for (int i=0; i<currentList.size(); i++) {
            randompool.add(i);
        }
        Collections.shuffle(randompool);

        int selected = (Integer) randompool.get(0);

        return selected;
    }


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
