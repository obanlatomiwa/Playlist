package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, Double duration){
        if (findSong(title) == null){
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (Song song : this.songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if (index >= 0 && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This song with " + trackNumber + " doesn't exist");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song song = findSong(title);
        if (song != null){
            return playList.add(song);
        }
        System.out.println("This song with title " + title + " doesn't exist");
        return false;
    }
}
