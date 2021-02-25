package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
	// write your code here
        Album album = new Album("Somewhere Between Beauty & Magic", "Joeboy");
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

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("Lonely", playList);  // Album: Somewhere Between Beauty & Magic
        albums.get(0).addToPlaylist("Runaway", playList);
        albums.get(0).addToPlaylist(4, playList);
        albums.get(1).addToPlaylist("Everything", playList);  // Album: Born of God
        albums.get(1).addToPlaylist("Olodumare", playList);
        albums.get(1).addToPlaylist(2, playList);


        play(playList);
    }

    public static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() != 0){
            System.out.println("Now Playing " + listIterator.next().toString());
        }else{
            System.out.println("This playlist is empty");
        }

        while (!quit){
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now Playing " + listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the beginning of the playlist");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Replaying " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We have gotten to the start of the playlist");
                        }
                    }else{
                        if (listIterator.hasNext()){
                            System.out.println("Replaying " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We have gotten to the end of the playlist");
                        }

                    }
                    break;

                case 4:
                    printPlaylist(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available commands \n Press");
        System.out.println("0  -> to quit\n" +
                "1  -> to play next song\n" +
                "2  -> to play previous song\n" +
                "3  -> to play current song\n" +
                "4  -> show all songs in the playlist\n" +
                "5  -> show commands again\n" +
                "6  -> remove current song\n");
    }

    private static void printPlaylist(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.next().toString());
        }
        System.out.println("==============================");

    }
}
