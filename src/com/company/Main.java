package com.company;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Album> albums;
    public static void main(String[] args) {
	// write your code here
        Album album = new Album("Somewhere Between Beauty & Magic", "JOeboy");
        album.addSong("Focus", 4.22);
        album.addSong("Runaway", 3.45);
        album.addSong("Lonely", 3.56);
        album.addSong("Oshe", 4.01);

        albums.add(album);

        album = new Album("Born of God", "Ada Ehi");
        album.addSong("Everything", 5.34);
        album.addSong("New Level", 6.34);
        album.addSong("Olodumare",11.04);

        albums.add(album);


    }
}
